package javaee.multithread.mod3;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumInit implements SquareSum  {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {
        Phaser phaser = new Phaser(numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Callable<Long>> callable = new ArrayList<>();
        IntStream.range(0, numberOfThreads).forEach(i -> callable.add(() -> {
            long threadResult = 0;
            int start = i * values.length/numberOfThreads;
            int end = (i+1) * values.length/numberOfThreads;
            for(int j = start; j < end; j++){
                threadResult += values[j] * values[j];
            }
            System.out.println(Thread.currentThread().getName() + " thread = " + threadResult);
            phaser.arriveAndAwaitAdvance();
            return threadResult;
        }));

        List<Future<Long>> futures = executorService.invokeAll(callable);
        long result = 0;
        for(Future<Long> future : futures){
            result += future.get();
        }
        executorService.shutdown();
        return result;
    }

}
