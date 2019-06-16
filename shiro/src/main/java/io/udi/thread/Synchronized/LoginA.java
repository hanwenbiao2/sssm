package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:24
 * @Description: TODO
 */
public class LoginA extends Thread {
    public void  run() {
        LoginServlet.doPost("a","aa");
    }
}
