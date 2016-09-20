package javaee.semaphore.mod3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by Den on 16.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        InitSemaphore semaphore = new InitSemaphore(3,5);
        Random random = new Random();

        IntStream.range(0, 10).forEach((i) -> new Thread(() -> {
            try{
                String name = Thread.currentThread().getName();
                System.out.println(name + " try to read");
                System.out.println("Count permits = " + semaphore.getAvailablePermits());
                semaphore.acquire();
                System.out.println(name + " reading...");
                Thread.sleep(random.nextInt(10000));
                semaphore.release();
                System.out.println(name + " finished");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());

    }


}
