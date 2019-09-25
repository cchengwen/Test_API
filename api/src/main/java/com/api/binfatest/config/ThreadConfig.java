package com.api.binfatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 *   Created by wen on 2019/09/25
 *   使用线程池配置类
 */
@Configuration
public class ThreadConfig {

    @Bean
    public ThreadPoolTaskExecutor poolTaskExecutor(){
        System.out.println("线程类");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(5);
        executor.setKeepAliveSeconds(6000);
        executor.setQueueCapacity(500);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        return executor;
    }
}
