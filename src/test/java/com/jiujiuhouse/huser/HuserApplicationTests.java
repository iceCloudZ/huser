package com.jiujiuhouse.huser;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.jiujiuhouse.huser.wxmini.config.WxMaConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuserApplicationTests {

	@Value("${wx.miniapp.configs[0].appid}")
	private String appid;

	@Test
	void contextLoads() {

	}

}
