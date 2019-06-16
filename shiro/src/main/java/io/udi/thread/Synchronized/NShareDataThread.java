package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:00
 * @Description: TODO
 */
public class NShareDataThread extends Thread {
    private int count = 5;
    public NShareDataThread(String name) {
        super(name);
        this.setName(name);
    }
    @Override
    public void run(){
        while ( count > 0 ) {
            count--;
            System.out.println("由 " + this.currentThread().getName() + " 计算 count = " + count);
        }
    }
}
