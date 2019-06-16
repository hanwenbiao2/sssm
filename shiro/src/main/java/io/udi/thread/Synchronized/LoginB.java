package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:24
 * @Description: TODO
 */
public class LoginB extends Thread {
    public void  run() {
        LoginServlet.doPost("b","bb");
    }
}
