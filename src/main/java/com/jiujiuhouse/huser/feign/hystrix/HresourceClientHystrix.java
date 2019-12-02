package com.jiujiuhouse.huser.feign.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.jiujiuhouse.huser.feign.HresourceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zihao.zhao
 */
@Slf4j
@Component
public class HresourceClientHystrix implements HresourceClient {

    @Override
    public String getTested() {
        return "{err:'熔断了'}";
    }
}
