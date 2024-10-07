package org.example.pr7;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class EmailSenderApp {
    private static final int TOTAL_EMAILS = 10000;

    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        List<String> emails = generateRandomEmails(TOTAL_EMAILS);
        int emailsPerThread = TOTAL_EMAILS / THREAD_COUNT;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * emailsPerThread;
            int end = start + emailsPerThread;
            EmailSenderThread emailSenderThread = new EmailSenderThread(emails.subList(start, end));
            threads.add(new Thread(emailSenderThread));
        }
        for (Thread thread : threads) {
            thread.start();
//            thread.join();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        // 1 - 1s
        // 2 - 1.5s
        // 3 - 1s
        // 4 - 1s
        // 5 - 0.5s
        // 1.5s - common time

        // in case when we have only 2 lines for 5 threads:
        // 1(1sec)  2(1.5sec)
        // 3(1sec)  4(1sec)
        // 5(0.5sec)
        // 2.5sec    2.5sec
        // but order can be different

        //
        threads.get(0).setPriority(Thread.MIN_PRIORITY); // 1; priority can be 1 - 10 included
        System.out.println("All emails have been sent!");
    }

    private static List<String> generateRandomEmails(int count){
        List<String> emails = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(10000);
            emails.add("user" + randomNumber + "@example.com");
        }
        return emails;
    }
}

