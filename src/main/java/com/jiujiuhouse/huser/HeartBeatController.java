package com.jiujiuhouse.huser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 健康检查
 * @author zihao.zhao
 */
@RestController
@Slf4j
public class HeartBeatController {

    @PostConstruct
    public void init(){
        log.info("健康检查服务初始化.");
    }

    @GetMapping("/health")
    public String HeartBeat() {

        return "health";
    }
}
