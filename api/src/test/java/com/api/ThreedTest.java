package com.api;

import com.api.binfatest.config.AsyncTaskService;
import com.api.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreedTest {

    @Autowired private AsyncTaskService asyncTaskService;
    @Autowired private UserService userService;

    //  测试异步线程插入数据到数据库
    @Test
    public void test2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> insert1 = userService.insert1();
        Future<String> insert2 = userService.insert2();
        Future<String> insert3 = userService.insert3();
        while (true){
            if (insert1.isDone()&& insert2.isDone()&& insert3.isDone()){
                // 三个任务完成，退出循环
                break;
            }
            Thread.sleep(5000);
        }
        long end = System.currentTimeMillis();
        System.out.println("全部完成，总耗时："+(end - start));
    }

    @Test
    public void test(){
        String msg = "SpringBoot线程测试 ...";
        System.out.println(Thread.currentThread().getName()+" : "+msg);
        asyncTaskService.executeAsync(msg);
        try{
            long start = System.currentTimeMillis();
            asyncTaskService.doreturn(2);
            Future<Long> future = asyncTaskService.asyncInvoke1();
            Future<Long> future1 = asyncTaskService.asyncInvoke2();
            Future<Long> future2 = asyncTaskService.asyncInvoke3();
            Long l1 = future.get();// 5000
            Long l2 = future1.get();//  3500
            Long l3 = future2.get();//  2500
            System.out.println(Thread.currentThread().getName()+" ************************************");
            System.out.println(Thread.currentThread().getName()+":"+(l1+l2+l3));
            System.out.println(Thread.currentThread().getName()+" ------------------------------------");
            System.out.println(Thread.currentThread().getName()+":"+(System.currentTimeMillis() - start));
            System.out.println(Thread.currentThread().getName()+" +++++++++++++++++++++++++++++++++++++");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
