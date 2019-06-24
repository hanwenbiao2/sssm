package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/24 16:46
 * @Description: TODO
 */
public class SynchronizedThisA extends Thread {
    private ObjectService service;
    public SynchronizedThisA( ObjectService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}
