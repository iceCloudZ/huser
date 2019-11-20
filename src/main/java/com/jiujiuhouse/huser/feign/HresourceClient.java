package com.jiujiuhouse.huser.feign;

import com.alibaba.fastjson.JSONObject;
import com.jiujiuhouse.huser.feign.hystrix.HresourceClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zihao.zhao
 */
@FeignClient(name = "hresource", fallback = HresourceClientHystrix.class)
public interface HresourceClient {

    @GetMapping("/hresource/houses")
    JSONObject getProfiles();
}
