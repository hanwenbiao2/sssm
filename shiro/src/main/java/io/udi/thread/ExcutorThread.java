package io.udi.thread;

import java.util.concurrent.Callable;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 19:54
 * @Description: TODO
 */
public class ExcutorThread implements  Callable {

    private String taskNum;

    public ExcutorThread(String taskNum) {
        this.taskNum = taskNum;
    }
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        long beginTime = System.currentTimeMillis();
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        long time = endTime- beginTime;
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
