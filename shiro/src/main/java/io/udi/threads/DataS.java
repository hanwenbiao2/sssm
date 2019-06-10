package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/10 17:39
 * @Description: TODO
 */
public class DataS {
/*    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }*/

    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        //线程a b c启动的时候，执行的是myThread的方法，此时数据共享
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println(name);
        a.start();
        System.out.println(Thread.currentThread().getName());
        b.start();
        c.start();

    }
}

class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    public MyThread() {

    }

    /*  @Override
      public void run() {
          super.run();
          while (count > 0) {
              count--;
              System.out.println("由 " + this.currentThread().getName()
                      + " 计算，count=" + count);
          }
      }*/
    @Override
    public synchronized void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + this.currentThread().getName()
                    + " 计算，count=" + count);
        }
    }
}
