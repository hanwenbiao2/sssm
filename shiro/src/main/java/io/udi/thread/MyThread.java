package io.udi.thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/15 20:58
 * @Description: TODO
 */
public class MyThread extends Thread{
    @Override
    public  void run(){
        super.run();//先执行父类的方法
        System.out.println("MyThread");//对父类方法的增强
    }

}
