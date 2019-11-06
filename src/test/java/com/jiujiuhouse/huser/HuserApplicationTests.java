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
		final WxMaService wxService = WxMaConfiguration.getMaService(appid);
		WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo("8XXBVDMSOZmvzNyX3xrXOQ==", "pOIDVDM+T4fE1fuJG9OE1TeLnLvnCWun5/DtmKHyVOskiQk4DyDjLQg6Cy382gJNp9twY4afC1sqmaqps/1CbTE3sO/UEjHxqlyqJ72t+cNdE3neoB4+s/eiKLOapMjm68ZUhQ8VPjPTY/vWU7qHi8+UyafMN7Zfbvz9NfGalM9nnN1or52PXw+UOV0Rsgdrl2i+DKEieuUZtNQOCzY5hA==", "cMFM2hUcVkc1cZlnxXjyaA==");
		System.out.println(phoneNoInfo.toString());

	}

}
