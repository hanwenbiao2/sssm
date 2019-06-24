package thread;

import io.udi.thread.Synchronized.*;
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
    public  void testsynchornizedAB() {
        HasSelfPrivateNum hasSelfPrivateNumA = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNumB = new HasSelfPrivateNum();

        SynchronizedA synchronizedA= new SynchronizedA(hasSelfPrivateNumA);
        SynchronizedB synchronizedB = new SynchronizedB(hasSelfPrivateNumB);
        synchronizedA.start();
        synchronizedB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testPublicVar() {
        try {
            PublicVar publicVar = new PublicVar();
            PublicVarThread publicVarThread= new PublicVarThread(publicVar);
            publicVarThread.start();
            Thread.sleep(200);
            publicVar.getValue();
            Thread.sleep(5000);
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


    @Test
    public  void testNegativeThread() {
        Task task = new Task();
        NegativeThread negativeThread = new NegativeThread(task);
        negativeThread.start();
        NegativeThread1 negativeThread1 = new NegativeThread1(task);
        negativeThread1.start();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }
        System.out.println(" 耗时： " + (endTime - beginTime) /1000);
    }

    @Test
    public  void testSynchornizedThis() {
        ObjectService service = new ObjectService();
        SynchronizedThisA loginA = new SynchronizedThisA(service);
        loginA.setName("a");
        loginA.start();
        SynchronizedThisB loginB = new SynchronizedThisB(service);
        loginA.setName("b");
        loginB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
