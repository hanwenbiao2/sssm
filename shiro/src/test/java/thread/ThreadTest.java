package thread;

import io.udi.thread.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: HWB
 * @DateTime: 2019/6/15 21:08
 * @Description: TODO
 */
public class ThreadTest {

    @Test
   public void testMyThread(){
        // 输出结果为main，这个main和main方法无任何关系，只是名字相同
        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }

    /**
     * @Author: HWB
     * @Description: 测试线程被cpu执行的顺序是随机的
     * @DateTime: 2019/6/15 21:30
     * @Params: [args]
     * @Return void
     */
    @Test
    public void testRandomThread(){
        RandomThread randomThread = new RandomThread();
        randomThread.setName("RandomThread");
        randomThread.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/**
* @Author: HWB
* @Description: Start()方法的顺序不代表线程启动的顺序
* @DateTime: 2019/6/15 21:41
* @Params: []
* @Return void
*/
    @Test
    public void testStartRandom(){
        StartRandom t11 = new StartRandom(11);
        StartRandom t12 = new StartRandom(12);
        StartRandom t13 = new StartRandom(13);
        StartRandom t14 = new StartRandom(14);
        StartRandom t15 = new StartRandom(15);
        StartRandom t16 = new StartRandom(16);
        StartRandom t17 = new StartRandom(17);
        StartRandom t18 = new StartRandom(18);
        StartRandom t19 = new StartRandom(19);
        StartRandom t110 = new StartRandom(110);
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t110.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMyRunnable()
    {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("运行结束");
    }
    @Test
    public void testCountOperate(){
        CountOperate countOperate = new CountOperate();
        Thread t1 = new Thread(countOperate);
        t1.setName("A");
        t1.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testYieldThread(){
        YieldThread yieldThread = new YieldThread();
        yieldThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInterruptThread(){

        try {
            InterruptThread interruptThread = new InterruptThread();

            interruptThread.start();
            Thread.sleep(2000);
            interruptThread.interrupt();
//            Thread.currentThread().interrupt();
////            System.out.println("是否停止1 ？ = " + interruptThread.interrupted());
////            System.out.println("是否停止2 ？ = " + interruptThread.interrupted());
////            System.out.println("是否停止3 ？ = " + interruptThread.interrupted());
            System.out.println("是否停止1 ？ = " + interruptThread.isInterrupted());
            System.out.println("是否停止2 ？ = " + interruptThread.isInterrupted());
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStopExceptionMethod() {

        try {
            StopExceptionMethodThread stopExceptionMethodThread = new StopExceptionMethodThread();
            stopExceptionMethodThread.start();
            Thread.sleep(1000);
            stopExceptionMethodThread.interrupt();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.print("main catch");
            e.printStackTrace();
        }
    }


        @Test
        public void testStopSleepMethod(){

            try {
                StopSleepMethodThread stopSleepMethodThread = new StopSleepMethodThread();
                stopSleepMethodThread.start();
                Thread.sleep(1000);
                stopSleepMethodThread.interrupt();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print( "main catch");
                e.printStackTrace();
            }
    }
    @Test
    public void testStopInterruptSleepMethod(){

        try {
            StopSleepMethodThread stopSleepMethodThread = new StopSleepMethodThread();
            stopSleepMethodThread.start();

            stopSleepMethodThread.interrupt();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print( "main catch");
            e.printStackTrace();
        }
    }

    @Test
    public void testDaemonThread(){

        try {
            DaemonThread daemonThread = new DaemonThread();
            daemonThread.setDaemon(true); //设置该线程为守护线程
            daemonThread.start();

            Thread.sleep(5000);
            System.out.println("我离开了，守护线程也就停止了");
        } catch (InterruptedException e) {
            System.out.print( "main catch");
            e.printStackTrace();
        }
    }
    @Test
    public void testCollable(){

        Callable<Integer> one = new SomeCallable<Integer>(1);
        FutureTask<Integer> oneTask = new FutureTask<Integer>(one);
        Thread oneThread = new Thread(oneTask);
        oneThread.start();
        try {
            System.out.println("获取返回值");
            Integer result = oneTask.get();//获取Callable放回值
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Test
    public  void testExecutorService () throws ExecutionException, InterruptedException {
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        List<Future> list = new ArrayList<Future>();

        for (int i = 0; i < taskSize ; i++) {
            Callable  callable = new ExcutorThread(""+i);
            Future future = pool.submit(callable);
            System.out.println(future.cancel(true) + "  "+ future.isCancelled() +"  " + future.isDone());
            list.add(future);
        }
        pool.shutdown();

        for (Future f : list){
            System.out.println(f.get().toString());
        }



    }

}
