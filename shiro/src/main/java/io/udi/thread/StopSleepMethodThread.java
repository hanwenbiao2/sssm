package io.udi.thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 14:53
 * @Description: TODO
 */
public class StopSleepMethodThread extends Thread {

//    public  void  run(){
//        try {
//
//            System.out.println("run begin");
//            Thread.sleep(20000);
//            System.out.println("run end");
//        }catch (InterruptedException e){
//            System.out.println("在沉睡中被停止！ 进入catch！+ " + this.isInterrupted());
//            e.printStackTrace();
//        }
//    }


    public  void  run(){
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println("i  = " + (i+1));
            }
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        }catch (InterruptedException e){
            System.out.println("先停止，在遇到了sleep！ 进入catch！+ " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
