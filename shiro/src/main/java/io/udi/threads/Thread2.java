package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/11 12:53
 * @Description: TODO
 */
public class Thread2 extends   Thread{

    @Override
    public void run(){

        try {
            while (true) {
                if (TestClass.list.size() == 5) {
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }else {
                    System.out.println("i am live");
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
