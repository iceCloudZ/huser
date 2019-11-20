package com.jiujiuhouse.huser.feign.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.jiujiuhouse.huser.feign.HresourceClient;

/**
 * @author zihao.zhao
 */
public class HresourceClientHystrix implements HresourceClient {

    @Override
    public String getTested() {
        return "{err:'熔断了'}";
    }
}
