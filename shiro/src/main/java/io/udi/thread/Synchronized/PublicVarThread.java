package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/20 22:49
 * @Description: TODO
 */
public class PublicVarThread extends Thread {
    private  PublicVar publicVar;

    public PublicVarThread(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B","BB");
    }
}
