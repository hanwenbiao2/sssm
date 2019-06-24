package io.udi.thread.Synchronized;

import javax.print.attribute.standard.RequestingUserName;

/**
 * @Author: HWB
 * @DateTime: 2019/6/20 21:43
 * @Description: TODO
 */
public class HasSelfPrivateNum {
    private int num = 0;
    synchronized  public  void addI(String username) {
        try {
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over !");

                Thread.sleep(2000);

        } else {
            num = 200;
            System.out.println(" b set over ! ");
        }
        System.out.println( username + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
