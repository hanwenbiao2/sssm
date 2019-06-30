package io.udi.thread.waitnotify;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:48
 * @Description: TODO
 */
public class AddThread extends Thread {
    private Object lock;

    public AddThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("已经发出通知");
                    }
                    System.out.println("添加" + (i + 1) + "个元素");

                    Thread.sleep(1000);

                }
            }
            } catch(InterruptedException e){
                e.printStackTrace();
            }

    }
}
