package io.udi.thread.waitnotify;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:33
 * @Description: TODO
 */
public class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {

                System.out.println(" 开始 notify time = " + System.currentTimeMillis());
            System.out.println(this.getState()+this.getName());
                lock.notify();
                System.out.println(" 结束 notify time = " + System.currentTimeMillis());
        }



    }
}
