package com.api.binfatest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 *   线程执行类
 */
@Service
public class AsyncTaskService {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);

    //  默认随机数
    Random random = new Random();

    //  表明是异步方法
    //  无返回值
    @Async
    public void executeAsync(String msg){
        System.out.println(Thread.currentThread().getName()+" 线程开始执行 "+ msg);
    }

    @Async
    public Future<String> doreturn(int i){
        logger.info(">>>>> 线程名 >>>> "+Thread.currentThread().getName());
        try {
            //  此方法需要调用500毫秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  消息汇总
        return new AsyncResult<>(String.format("这个是第 {%S} 个异步调用的", i));
    }

    @Async
    public Future<Long> asyncInvoke1(){
        long start = System.currentTimeMillis();
        Future<Long> future = null;
        try {
            Thread.sleep(5000);
            future = new AsyncResult<>((System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return future;
    }

    public Future<Long> asyncInvoke2(){
        long start = System.currentTimeMillis();
        Future<Long> future = null;
        try {
            Thread.sleep(3500);
            future = new AsyncResult<>((System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return future;
    }

    public Future<Long> asyncInvoke3(){
        long start = System.currentTimeMillis();
        Future<Long> future = null;
        try {
            Thread.sleep(2500);
            future = new AsyncResult<>((System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return future;
    }
}
