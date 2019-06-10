package threads;

import io.udi.threads.MyRunnable;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/10 17:31
 * @Description: TODO
 */
public class ThreadTest {
/*
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        System.out.println("代码的执行结果与代码的顺序无关");
    }*/

//    public static void main(String[] args) {
//        MyThread myThread=new MyThread();
//        myThread.run();
//        System.out.println("如果是直接执行run方法，肯定是按代码顺序执行的，因为是通过主线程调用的");
//    }
    public static void main(String[] args) {
        Runnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
        System.out.println("运行结束!");
    }
}
class MyThread extends Thread
{
    public void run()
    {
        System.out.println("创建的线程");
    }
}
