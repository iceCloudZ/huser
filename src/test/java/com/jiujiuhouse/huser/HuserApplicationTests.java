package com.jiujiuhouse.huser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuserApplicationTests {

	@Value("${wx.miniapp.configs[0].appid}")
	private String appid;

}
