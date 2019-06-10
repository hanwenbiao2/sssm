package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/10 21:35
 * @Description: TODO
 */
public class Priority  {
    public static void main(String[] args) {
        System.out.println("main thread begin priority="
                + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end   priority="
                + Thread.currentThread().getPriority());
        MyThread4 thread4 = new MyThread4();
        thread4.start();
    }
}
class MyThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread4 run priority=" + this.getPriority());
        MyThread5 thread2 = new MyThread5();
        thread2.setPriority(5);
        thread2.start();
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread5 run priority=" + this.getPriority());
    }
}




