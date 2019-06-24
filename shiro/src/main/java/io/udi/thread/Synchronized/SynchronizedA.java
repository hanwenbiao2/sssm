package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/20 21:47
 * @Description: TODO
 */
public class SynchronizedA extends  Thread {

    private HasSelfPrivateNum hasSelfPrivateNum ;

    public SynchronizedA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        this.hasSelfPrivateNum.addI("a");
    }
}
