//package org.example.pr24;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//public class Pr24Application {
//
//    public static void main(String[] args) {
//        CompletableFuture<String> future = create();
/// /        future.thenAccept(System.out::println); // Hello mates!
/// /        future.thenAccept(data -> System.out.println(data))
/// /                .thenRun(() -> System.out.println("This never dies!")) // Runnable;
/// /                .thenRun(() -> System.out.println("This really never dies!")); // Hello mates! This never dies! This really never dies!
//        future
//                .thenApply(String::toUpperCase)
//                .thenAccept(System.out::println); // HELLO MATES!
//
//    }
//
//    private static CompletableFuture<String> create() {
//        return CompletableFuture.supplyAsync(
//                () -> "Hello mates!"
//        ); // цей код буде запускатися в окремому потоці
//    }
//
//    // Supplier<T> T get()
//    // Predicate<T> boolean test(T t)
//    // Function<T,R> R apply(T t)
//    // Consumer<T> void accept(T t)
//
//}

package org.example.pr24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class Pr24Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("Before CF");
//        try {
//            System.out.println(create().get()); // блокуюча операця
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("After CF"); // очікує поки не виконається код з методом get()

//        System.out.println("Before CF");
//        create().thenAccept(System.out::println);
//        System.out.println("After CF"); // не очікує виконання create, тому що це асинхронний код
//        try {
//            Thread.sleep(1200);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Before CF");
        System.out.println(create().getNow("dummy data"));
//        System.out.println(create().get()); // блокує
        System.out.println("After CF"); // не очікує; Before CF dummy data After CF
    }

    private static CompletableFuture<String> create() {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Hello mates!";
                }
        );
    }

    // Supplier<T> T get()
    // Predicate<T> boolean test(T t)
    // Function<T,R> R apply(T t)
    // Consumer<T> void accept(T t)

}
