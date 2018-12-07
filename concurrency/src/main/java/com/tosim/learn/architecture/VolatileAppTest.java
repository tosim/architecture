package com.tosim.learn.architecture;

/**
 * @author yaoyicheng
 * @data 2018/11/20 11:11
 */
public class VolatileAppTest {

    public static void main(String[] args) throws InterruptedException {
        VolatileApp volatileApp = new VolatileApp();
        int i;
        for (i = 0;i < 10;i++) {
            int finalI = i;
           Thread t = new Thread(() -> {
                System.out.println("i = " + finalI);
                volatileApp.settName("T_" + finalI);
                System.out.println(volatileApp.gettName() + "\n");
            });
            t.start();
            t.join();
        }
    }
}
