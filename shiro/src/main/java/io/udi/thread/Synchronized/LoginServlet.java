package io.udi.thread.Synchronized;

/**
 * @Author: HWB
 * @DateTime: 2019/6/16 21:20
 * @Description: TODO
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static void doPost(String username, String password) {
        try {


            usernameRef = username;

            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println(" username = " + usernameRef + " password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
