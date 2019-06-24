package io.udi.threads;

/**
 * @Author: HWB
 * @DateTime: 2019/6/11 12:53
 * @Description: TODO
 */
public class Thread1  extends   Thread{

    @Override
    public void run(){

        try {
            for (int i = 0; i < 10; i++) {
                TestClass.list.add(1);
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
