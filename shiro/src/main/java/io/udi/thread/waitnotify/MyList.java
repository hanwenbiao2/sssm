package io.udi.thread.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HWB
 * @DateTime: 2019/6/30 13:45
 * @Description: TODO
 */
public class MyList {
    private static  List list = new ArrayList();

    public static void add() {
        list.add("anyThing");
    }

    public static int  size() {
        return list.size();
    }
}
