package io.udi.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HWB
 * @DateTime: 2019/6/11 16:22
 * @Description: TODO
 */
public class TestClass {
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getPriority());
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread2.start();

        thread1.start();

    }
}
