package io.udi.thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/15 21:36
 * @Description: Start()方法的顺序不代表线程启动的顺序
 */
public class StartRandom extends Thread {
    private int i ;
    public StartRandom(int i ){
        super();
        this.i = i;
    }
    @Override
    public  void run(){

        System.out.println(i);
    }
}
