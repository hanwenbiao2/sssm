package io.udi.thread.Synchronized;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: HWB
 * @DateTime: 2019/6/24 17:07
 * @Description: TODO
 */
public class TaskA {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println(" noSynchronized threadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
        }
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(" noSynchronized threadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }

    }
}
