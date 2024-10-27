//package org.example.pr26;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//public class Pr26Application {
//    public static void main(String[] args) {
//        create()
//                .thenApply(data -> data * 2)
//                .thenAccept(System.out::println)
//                .exceptionally(throwable -> handleException(throwable));
//        // then
//        // then
//        // exceptionally
//        // then
//        // then
//        // exceptionally
//    }
//
//    private static Void handleException(Throwable throwable) {
//        System.out.println(throwable);
//        return null;
//    }
//
//    private static CompletableFuture<Integer> create() {
//        return CompletableFuture.supplyAsync(() -> compute());
//    }
//
//    private static int compute() {
//        if (true) {
//            throw new RuntimeException("Exception from compute method");
//        }
//        return 2;
//    }
//
//}


package org.example.pr26;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class Pr26Application {
    public static void main(String[] args) {
        create()
                .exceptionally(Pr26Application::handleException) // -2 тому що логіка йде далі і значення множиться на 2
                .thenApply(data -> data * 2)
//                .exceptionally(Pr26Application::handleException) // -1
                .thenAccept(System.out::println);
//        .exceptionally(Pr26Application::handleException) // - it does not work because in this example the previous
// method does not return Void
    }

    private static Integer handleException(Throwable throwable) {
        System.out.println(throwable);
        return -1;
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute() {
        if (true) {
            throw new RuntimeException("Exception from compute method");
        }
        return 2;
    }

}
