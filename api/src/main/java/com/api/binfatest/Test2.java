package com.api.binfatest;

/**
 *   懒汉模式线程安全
 */
public class Test2 {
    private static Test2 test2;
    public static String VALUE = "Hi";

    private Test2(){
        System.out.println("执行构造方法");
    }

    public static Test2 test2(){
        if (test2 == null){
            System.out.println("构造");
            test2 = new Test2();
        }
        return test2;
    }

    public static void main(String[] args) {
        System.out.println(test2);
        for (int i = 0; i < 5; i++) {
            System.out.println(Test2.VALUE);
        }
    }
}
