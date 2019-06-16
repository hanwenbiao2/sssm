package io.udi.thread;

import java.util.Random;

/**
 * @Author: HWB
 * @DateTime: 2019/6/15 21:15
 * @Description: CPU以不确定的方式即随机的方式来调用线程中的run方法
 */
public class RandomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
