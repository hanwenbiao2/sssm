package thread;

import io.udi.thread.Synchronized.LoginA;
import io.udi.thread.Synchronized.LoginB;
import io.udi.thread.Synchronized.NShareDataThread;
import io.udi.thread.Synchronized.ShareDataThread;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:03
 * @Description: TODO
 */
public class SynchornizedTest {
    @Test
    public void testNShareDateThread() {
        NShareDataThread nShareDataThread1 = new NShareDataThread("A");
        NShareDataThread nShareDataThread2 = new NShareDataThread("B");
        NShareDataThread nShareDataThread3 = new NShareDataThread("C");
        nShareDataThread1.start();
        nShareDataThread3.start();
        nShareDataThread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShareDateThread() {
        ShareDataThread shareDataThread = new ShareDataThread();
        Thread a = new Thread(shareDataThread, "A");
        Thread b = new Thread(shareDataThread, "b");
        Thread c = new Thread(shareDataThread, "c");
        Thread d = new Thread(shareDataThread, "d");
        Thread f = new Thread(shareDataThread, "f");
        a.start();
        b.start();
        c.start();
        d.start();
        f.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testLoginAB() {
        LoginA loginA = new LoginA();
        LoginB loginB = new LoginB();
        loginA.start();
        loginB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
