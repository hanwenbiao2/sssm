package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/10 21:06
 * @Description: TODO
 */
public class InterruptThread {
    public static void main(String[] args) {
        try {
            MyThread1 thread = new MyThread1();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
            System.out.println("是否停止1？="+thread.interrupted());//false
            System.out.println("是否停止2？="+thread.interrupted());//false main线程没有被中断!!!

            Thread.currentThread().interrupt();
            System.out.println("是否停止1？="+Thread.interrupted());//true
            System.out.println("是否停止2？="+Thread.interrupted());//false
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
