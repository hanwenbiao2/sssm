package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/24 15:40
 * @Description: TODO
 */
public class NegativeThread1 extends Thread {
    private Task task;

    public NegativeThread1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
//        task.doLongTimeTask();
        task.doLongTimeTaskA();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
