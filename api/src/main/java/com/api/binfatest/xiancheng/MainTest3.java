package com.api.binfatest.xiancheng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class MainTest3 {

    @Autowired private ThreadPoolTaskExecutor executor;

    public void add(){
     Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
             System.out.println(Thread.currentThread().getName());
         }
     });
     thread.start();
    }

    public void bbs(){
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
//        new MainTest3().add();
            new MainTest3().bbs();
        }
    }
}
