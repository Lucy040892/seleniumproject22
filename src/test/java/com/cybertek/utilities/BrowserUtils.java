package com.cybertek.utilities;

public class BrowserUtils {
    /**
     * Method that will accept int
     * Wait for given second duration
     */
    //1sec = 1000 milli seconds
    //1* 1000 = 1000
    //Thread.sleep(1000);
    //BrowserUtils.sleep(1); -> second

    public static void sleep(int seconds) {
        seconds*=1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
