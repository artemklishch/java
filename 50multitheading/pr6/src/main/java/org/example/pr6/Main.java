//package org.example.pr6;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello World! Thread name is: " + Thread.currentThread().getName());
//        WorkerThread workerThread1 = new WorkerThread();
//        WorkerThread workerThread2 = new WorkerThread();
//
//        Thread thread1 = new Thread(workerThread1, "WorkerThread 1");
//        Thread thread2 = new Thread(workerThread2, "WorkerThread 1");
//        thread1.start();
//        thread2.start();
//
//        System.out.println("Main thread is done");
//    }
//}
//
//class WorkerThread implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Worker thread is running");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Worker thread is complete");
//    }
//}
//
////Hello World! Thread name is: main
////Main thread is done
////Worker thread is running
////Worker thread is running
////Worker thread is complete
////Worker thread is complete

package org.example.pr6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World! Thread name is: " + Thread.currentThread().getName());
        WorkerThread workerThread1 = new WorkerThread();
        WorkerThread workerThread2 = new WorkerThread();

        Thread thread1 = new Thread(workerThread1, "WorkerThread 1");
        Thread thread2 = new Thread(workerThread2, "WorkerThread 1");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Main thread is done"); // чекає, коли відпрацює код із потоків thread1, thread2
    }
}

class WorkerThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker thread is running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Worker thread is complete");
    }
}
//Hello World! Thread name is: main
//Worker thread is running
//Worker thread is running
//Worker thread is complete
//Worker thread is complete
//Main thread is done
