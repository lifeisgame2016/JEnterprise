package javaee.multithread.mod3;


import java.util.concurrent.ExecutionException;

public interface SquareSum {

    long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException;
}
