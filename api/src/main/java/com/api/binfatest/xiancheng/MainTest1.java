package com.api.binfatest.xiancheng;

import java.util.Vector;

/**
 *   线程案例测试一
 */
public class MainTest1 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true){
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            //  移除元素线程
            System.out.println("移除前："+vector);
            Thread remove = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                        System.out.println(i);
                    }
                }
            });

            //  打印线程元素

            Thread print = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });

            remove.start();
            print.start();
            System.out.println("移除后："+vector);
             while (Thread.activeCount() > 5);
             break;
        }
    }
}
