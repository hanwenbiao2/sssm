package thread;

import io.udi.thread.waitnotify.NotifyThread;
import io.udi.thread.waitnotify.WaitThread;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:39
 * @Description: TODO
 */
public class WaitNotify {

    @Test
    public void testWaitNotify(){
        try {
        Object lock = new Object();
        WaitThread waitNotify = new WaitThread(lock);
        waitNotify.start();
            System.out.println(waitNotify.getState()+ waitNotify.getName());
            Thread.sleep(3000);
            System.out.println(waitNotify.getState());
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
            Thread.sleep(3000);
            System.out.println(waitNotify.getState()+ "-" + notifyThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
