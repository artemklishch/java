//package org.example.pr22;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@SpringBootApplication
//public class Pr22Application {
//
//    public static void main(String[] args) {
////        ExecutorService executorService = Executors.newFixedThreadPool(5);
////        ExecutorService executorService = Executors.newFixedThreadPool(5); // result - Thread is technically completed. Name: pool-1-thread-3, hashcode: 1412291393
////        ExecutorService executorService = Executors.newSingleThreadExecutor(); // single thread
//        ExecutorService executorService = Executors.newCachedThreadPool(); // створює запасні потоки, але перевикористовує ту, які звільняються, тут імплементовується інтерфейс AutoClosable
//        Callable<String> callable = new CallableTask();
//        for (int i = 0; i < 3000; i++) {
//            executorService.submit(callable);
//        }
//
//        executorService.shutdown(); // цей метод очікує коли всі задачі будуть виконані і тільки потім припиняє потоки
////        executorService.shutdownNow(); // цей метод не очікує і відразу припиняє пото
////        List<Runnable> runnables = executorService.shutdownNow();
////        System.out.println("runnables: " + runnables); // runnables: [java.util.concurrent.FutureTask@7e0e6aa2[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@365185bd[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@18bf3d14[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@4fb64261[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@42607a4f[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@782663d3[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@1990a65e[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@64485a47[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@25bbf683[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@6ec8211c[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@7276c8cd[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@544a2ea6[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@2e3fc542[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@150c158[Not completed, task = org.example.pr22.CallableTask@12c8a2c0], java.util.concurrent.FutureTask@4524411f[Not completed, task = org.example.pr22.CallableTask@12c8a2c0]]
//    }
//
//}

package org.example.pr22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
public class Pr22Application {

    public static void main(String[] args) {
//        try (ExecutorService executorService = Executors.newCachedThreadPool()) { // JEP 425
//            Callable<String> callable = new CallableTask();
//            for (int i = 0; i < 3000; i++) {
//                executorService.submit(callable);
//            }
//            executorService.shutdown();
//        }

//        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) { // JEP 425
//            Callable<String> callable = new CallableTask();
//            for (int i = 0; i < 10; i++) {
//                Future<String> future = executorService.submit(callable);
//                String value = future.get();
//                System.out.println(value);
//            }
//            executorService.shutdown();
//        } catch (ExecutionException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Callable<String> callable = new CallableTask();
//        for (int i = 0; i < 10; i++) {
//            Future<String> future = executorService.submit(callable);
//            String value = null;
//            try {
//                value = future.get(); // виклик цього методу в цьому прикладі є блокуючим і потоки виконуються по черзі
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(value);
//        }
//        executorService.shutdown();


        System.out.println("Start: " + LocalTime.now());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> callable = new CallableTask();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(callable);
            futures.add(future);
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                String value = future.get();
                System.out.println(value);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Exception from the main method", e);
            }
        }
        System.out.println("Finish: " + LocalTime.now());
    }

}
