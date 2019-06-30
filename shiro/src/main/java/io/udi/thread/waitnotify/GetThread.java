package io.udi.thread.waitnotify;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:54
 * @Description: TODO
 */
public class GetThread extends Thread {
    private Object lock;

    public GetThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
        synchronized (lock) {
            if (MyList.size() != 5 ) {
                System.out.println("wait begin " + System.currentTimeMillis());

                    lock.wait();

                System.out.println("wait end " + System.currentTimeMillis());
            }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
