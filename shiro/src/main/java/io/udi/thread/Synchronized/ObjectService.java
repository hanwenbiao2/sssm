package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/24 16:46
 * @Description: TODO
 */
public class ObjectService {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println( "begin time = " + System.currentTimeMillis());
                Thread.sleep( 2000);
                System.out.println( "end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e)  {
            e.printStackTrace();
        }
    }

    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println( "begin time = " + System.currentTimeMillis());
                Thread.sleep( 2000);
                System.out.println( "end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e)  {
            e.printStackTrace();
        }
    }
}
