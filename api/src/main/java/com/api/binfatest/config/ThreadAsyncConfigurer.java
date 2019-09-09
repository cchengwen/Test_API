package com.api.binfatest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 *  Created by wen on 2019/09/09
 *  springboot里面创建异步线程配置类
 */
@Configuration
@EnableAsync
public class ThreadAsyncConfigurer implements AsyncConfigurer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public Executor getAnsyncExecutor(){
        logger.info("异步线程配置类启动 ....");
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //  设置核心线程数
        taskExecutor.setCorePoolSize(50);
        //   设置最大线程数
        taskExecutor.setMaxPoolSize(100);
        //  线程池所使用的线程缓存队列
        taskExecutor.setQueueCapacity(30);
        //  等待任务在关机时完成，表明等待所有线程执行完
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //   等待时间（默认为0，此时立即停止），并没有等待多少秒后强制停止
        taskExecutor.setAwaitTerminationSeconds(60);
        //  线程名称前缀
        taskExecutor.setThreadNamePrefix("MyAsync - ");
        //  初始化线程
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
