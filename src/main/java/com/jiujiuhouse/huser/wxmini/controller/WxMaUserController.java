package com.jiujiuhouse.huser.wxmini.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.jiujiuhouse.huser.entity.Profile;
import com.jiujiuhouse.huser.repository.ProfileRepository;
import com.jiujiuhouse.huser.wxmini.config.WxMaConfiguration;
import com.jiujiuhouse.huser.wxmini.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wx/user")
public class WxMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wx.miniapp.configs[0].appid}")
    private String appid;

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * 登陆接口
     */
    @GetMapping("/login")
    public String login(String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());

            // 查看用户是不是已经访问过
            Profile existProfile = profileRepository.findByOpenId(session.getOpenid());

            if (profileRepository.findByOpenId(session.getOpenid()) == null) {
                // 新增用户
                Profile result = profileRepository.save(new Profile(session.getOpenid(), session.getSessionKey()));
                logger.info("用户新增成功,[{}]", JsonUtils.toJson(result));
            } else {
                existProfile.setOpenId(session.getOpenid());
                existProfile.setSessionKey(session.getSessionKey());
                Profile result = profileRepository.save(existProfile);
                logger.info("用户更新成功,更新前[{}],更新后[{}]", JsonUtils.toJson(existProfile), JsonUtils.toJson(result));
            }
            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
//        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//            return "user check failed";
//        }

        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(userInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public String phone(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
//        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//            return "user check failed";
//        }

        // 查询用户信息
        Profile profile = profileRepository.findBySessionKey(sessionKey);
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        profile.setPhoneNumber(phoneNoInfo.getPhoneNumber());
        profile.setCountryCode(phoneNoInfo.getCountryCode());
        Profile result = profileRepository.save(profile);
        logger.info("用户更新手机号成功,更新前[{}],更新后[{}]", JsonUtils.toJson(profile), JsonUtils.toJson(result));

        return JsonUtils.toJson(phoneNoInfo);
    }

}
