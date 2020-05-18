package com.herokuapp.theirinternet.base;

public class TestUtilities extends BaseTest {

    //Staic Sleep
    protected  void sleep (long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
