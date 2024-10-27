//package org.example.pr25;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//public class Pr25Application {
//
//    public static void main(String[] args) {
//        System.out.println("In main: " + Thread.currentThread().getName());
//        create()
//                .thenAccept(Pr25Application::print); // це відпрацьовує в потоці main в цьому прикладі
//        // це пов'язано з тим, що операція виконується швидко і при даній сигнатурі логіка ен встигає перемикатися в потік
//        // який мав би створтися за допомогою інтерфейсу CompletableFuture
//        System.out.println("Main done!");
////        In main: main
////        Data: Hello mates!. Thread: main
////        Main done!
//    }
//
//    public static CompletableFuture<String> create() {
//        return CompletableFuture.supplyAsync(() -> "Hello mates!");
//    }
//
//    private static void print(String data) {
//        System.out.printf(
//                "Data: %s. Thread: %s%n", data, Thread.currentThread().getName()
//        );
//    }
//
//}


//package org.example.pr25;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//public class Pr25Application {
//
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("In main: " + Thread.currentThread().getName());
//        CompletableFuture<String> completableFuture = create();
//        Thread.sleep(100);
//        completableFuture.thenAccept(Pr25Application::print);
//        Thread.sleep(200);
//        System.out.println("Main done!");
////        In main: main
////        Data: Hello mates!. Thread: ForkJoinPool.commonPool-worker-1
////        Main done!
//
//        // nu of cores - 1...- the function to calculate the number of threads
//    }
//
//    public static CompletableFuture<String> create() {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Hello mates!";
//        });
//    }
//
//    private static void print(String data) {
//        System.out.printf(
//                "Data: %s. Thread: %s%n", data, Thread.currentThread().getName()
//        );
//    }
//
//}


package org.example.pr25;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Pr25Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In main: " + Thread.currentThread().getName());
        CompletableFuture<String> completableFuture = create();
        Thread.sleep(100);
        completableFuture.thenAccept(Pr25Application::print);
        Thread.sleep(200);
        System.out.println("Main done!");
//        In main: main
//        Data: Hello mates!. Thread: pool-1-thread-1
//        Main done!
        // num of cores - 1...- the function to calculate the number of threads
    }

    public static CompletableFuture<String> create() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executorService.shutdownNow();
            return "Hello mates!";
        }, executorService);
    }

    private static void print(String data) {
        System.out.printf(
                "Data: %s. Thread: %s%n", data, Thread.currentThread().getName()
        );
    }

}
