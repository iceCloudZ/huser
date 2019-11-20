package com.jiujiuhouse.huser;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 健康检查
 *
 * @author zihao.zhao
 */
@RestController
@Slf4j
public class HeartBeatController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostConstruct
    public void init() {
        log.info("健康检查服务初始化.");
    }

    @GetMapping("/health")
    public String HeartBeat() {

        return "health";
    }

    /**
     * 返回远程调用的结果
     *
     * @return
     */
    @RequestMapping("/getservicedetail")
    public String getservicedetail(
            @RequestParam(value = "servicename", defaultValue = "") String servicename) {
        return "Service [" + servicename + "]'s instance list : " + JSON.toJSONString(discoveryClient.getInstances(servicename));
    }

    /**
     * 返回发现的所有服务
     *
     * @return
     */
    @RequestMapping("/services")
    public String services() {
        return this.discoveryClient.getServices().toString()
                + ", "
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
