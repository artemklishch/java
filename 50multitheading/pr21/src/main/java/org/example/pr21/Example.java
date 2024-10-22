package org.example.pr21;

//public class Example implements Runnable {
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

import java.util.concurrent.Callable;

public class Example implements Callable<String> {
    //    @Override
//    public String call() throws Exception {
//        Thread.sleep(5000);
//        return "Hello methods";
//    }
//    @Override
//    public String call() throws InterruptedException {
//        Thread.sleep(5000);
//        return "Hello methods";
//    }

    @Override
    public String call() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello methods";
    }
}
