package com.api.binfatest;



/**
 *   线程相关
 */
public class Test extends Thread {

    // 构造方法给线程名字赋值
    public Test(String name){
        super(name);
    }

    //  为了保持票数一致，票数要静态
    static int ticketNum = 50;

    //  创建一个静态钥匙， 并给一个任意的值
    static  Object obj = "aa";

    @Override
    public void run() {
        while (ticketNum > 0){
            synchronized (obj){
                System.out.println(getName()+" ++++++++  拿到钥匙 ++++++++++++++++ ："+obj);
                if (ticketNum > 0){
                    System.out.println(getName() +"卖出了第 "+ ticketNum +" 票！");
                    ticketNum --;
                    System.out.println(getName()+" -------  释放锁 ------ ："+obj);
                    System.out.println();
                    System.out.println();
                    break;
                }else {
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Test t = new Test("窗口1");
        Test t2 = new Test("窗口2");
        Test t3 = new Test("窗口3");
        Test t4 = new Test("窗口4");
        t.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
