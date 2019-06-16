package io.udi.thread;

import java.util.concurrent.Callable;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 17:25
 * @Description: TODO
 */
public class SomeCallable<V> implements Callable<V> {
    private  V  i;
    public SomeCallable(V i){
        this.i = i;
    }

    public V call() throws Exception {
        Thread.sleep(10000);
        System.out.println("使用Callable<V>和Future来实现线程");

        return this.i;
    }

}
