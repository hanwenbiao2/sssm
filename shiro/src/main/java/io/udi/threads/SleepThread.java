package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/10 21:27
 * @Description: TODO
 */
public class SleepThread {
    public static void main(String[] args) {
        try {
            MyTread2 thread = new MyTread2();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

class MyTread2 extends Thread {
    public void  run() {
        super.run();

        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止!进入catch!"+this.isInterrupted());
            e.printStackTrace();
        }

    }
}
