package org.example.pr7;

import java.util.List;
import java.util.Random;

public class EmailSenderThread implements Runnable {
    private List<String> emails;

    public EmailSenderThread(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void run() {
        for (String email : emails) {
            sendEmail(email);
        }
        try {
            Thread.sleep(new Random().nextInt(1500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Thread %s is done%n", Thread.currentThread().getName());
    }

    private void sendEmail(String email) {
        // implement some code
    }
}
