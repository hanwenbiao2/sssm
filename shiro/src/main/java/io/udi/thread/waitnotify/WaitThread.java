package io.udi.thread.waitnotify;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:33
 * @Description: TODO
 */
public class WaitThread extends Thread {
    private Object lock;

    public WaitThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {


            try {
                System.out.println(this.getState()+ this.getName());
                System.out.println(" 开始 wait time = " + System.currentTimeMillis());
                lock.wait(6000);
                System.out.println(" 开始 end time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
