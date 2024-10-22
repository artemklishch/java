package org.example.pr22;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.printf(
                "Thread is technically completed. Name: %s, hashcode: %s%n",
                Thread.currentThread().getName(),
                Thread.currentThread().hashCode()
        );
//        if (true) {
//            throw new Exception("Exception from the call method");
//        } // але ця помилка буде оброблюватись батьківським блоком try...catch і буде виникати як така
//        тільки при виклику методу get
        return "Hello mates!";
    }
}
