package org.example.pr27;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootApplication
public class Pr27Application {

    public static void main(String[] args) throws InterruptedException {
//        List<Integer> sharedList = new ArrayList<>(); // це призводить до проблеми race condition,
        // очікуване значення 2000 в цьому прикладі не буде отримуватись, оскільки два різні потоки перетинаються

        List<Integer> sharedList = new CopyOnWriteArrayList<>(); // буде повертати вірне значення 2000, як ніби
        // в одному потоці
        // тут при модифікації буде створюватись нова версія списку, а інші потоки можуть зчитувати стару версію, поки не відбулось оновлення
        // відповідно - не відбувається блокування,
        // а потім старий масив змінюється на оновлений

        // thread A tries to add elements to the list
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedList.add(i);
            }
        });

        // thread B tries to add elements to the list
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedList.add(i);
            }
        });

        threadA.start();
        threadB.start();

        // wait for threads to finish
        threadA.join();
        threadB.join();

        System.out.println("Expected list size: " + 2000);
        System.out.println("Actual list size: " + sharedList.size());
    }

}
