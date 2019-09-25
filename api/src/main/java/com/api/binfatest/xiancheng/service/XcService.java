package com.api.binfatest.xiancheng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class XcService {
    //  自动注入线程
    @Autowired private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public String adds(){
        //   使用线程
        threadPoolTaskExecutor.execute(()->{
            //  里边处理业务
            System.out.println(Thread.currentThread().getName());
        });
        return "SUCCESS";
    }
}
