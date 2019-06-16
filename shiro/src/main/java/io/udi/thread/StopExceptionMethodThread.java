package io.udi.thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 14:36
 * @Description: TODO
 */
public class StopExceptionMethodThread extends Thread {

//    public  void  run(){
//        super.run();
//        for (int i = 0; i < 500000; i++){
//            if (this.interrupted()){
//                System.out.println("已经是停止状态！我要退出");
//                break;
//            }
//            System.out.println("i = " + (i +1));
//        }
//        System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
//
//    }

    public  void  run(){
        super.run();
        try {
        for (int i = 0; i < 500000; i++){
            if (this.interrupted()){
                System.out.println("已经是停止状态！我要退出");

                    throw  new InterruptedException();

            }
            System.out.println("i = " + (i +1));
        }

        System.out.println("我在for 下面");
        } catch (InterruptedException e) {
            System.out.print("进入Thread.java类run方法中的catch了！ ");
            e.printStackTrace();
        }

    }
}

