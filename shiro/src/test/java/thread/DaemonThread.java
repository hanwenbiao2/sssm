package thread;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 17:07
 * @Description: TODO
 */
public class DaemonThread extends Thread {
 private int i = 0;
 public void run() {
     try{
         while (true) {
             System.out.println("i =" + (i+1));
             Thread.sleep(1000);
         }
     }catch (InterruptedException e){
         e.printStackTrace();
     }
 }
}
