package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:07
 * @Description: TODO
 */
public class ShareDataThread extends Thread {
    private int count = 5;
    public ShareDataThread(String name) {
        super(name);
        this.setName(name);
    }

    public ShareDataThread() {

    }

//    @Override
//    public void run(){
//        while ( count > 0 ) {
//            count--;
//            System.out.println("由 " + this.currentThread().getName() + " 计算 count = " + count);
//        }
//    }

    @Override
   synchronized public void run(){
        while ( count > 0 ) {
            count--;
            System.out.println("由 " + this.currentThread().getName() + " 计算 count = " + count);
        }
    }
}
