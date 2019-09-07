package com.api.binfatest;

/**
 *  线程异步
 */
public class Test3 {
    public void method(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("6666666");
    }

    public static void main(String[] args) {
        final Test3 t = new Test3();
        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                t.method();
            }
        }, "t1");

        Thread r2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.method();
            }
        }, "t2");

        r2.start();
        r.start();
    }

}
