package com.api.binfatest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 *  Created by wen on 2019/9/7
 *  多线程配置类
 */
//@Configuration
//@EnableAsync  //  开启异步线程，注意：在配置类中使用@EnableAsync 该注解后，不用在启动中再添加此注解
public class AsyncTaskConfig implements AsyncConfigurer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // ThredPoolTaskExcutor的处理流程
    // 当池子大小小于corePoolSize，就新建线程，并处理请求
    // 当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去workQueue中取任务并处理
    // 当workQueue放不下任务时，就新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize，就用RejectedExecutionHandler来做拒绝处理
    // 当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(50);  //  核心线程
        taskExecutor.setMaxPoolSize(100);//   最大线程数
        taskExecutor.setQueueCapacity(200);  //  等待队列
        taskExecutor.setThreadNamePrefix("zs_taskThreed - ");  //  线程名称前缀
        taskExecutor.initialize();
        logger.info("异步线程配置类：[{}]", taskExecutor);
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
