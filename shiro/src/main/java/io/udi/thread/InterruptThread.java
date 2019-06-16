package io.udi.thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 12:40
 * @Description: TODO
 */
public class InterruptThread extends Thread {
    public  void  run(){
        super.run();

        for (int i = 0; i < 500000; i++){
            System.out.println("i =" + (i+1) );
        }
    }
}
