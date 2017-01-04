package javaee.multithread.mod3;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class Runner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        int[] values = new int[10];
        IntStream.range(0, 10).forEach(i -> values[i] = random.nextInt(50));
        IntStream.range(0, 10).forEach(i -> System.out.print(values[i] + " "));
        System.out.println();
        System.out.println(new SquareSumInit().getSquareSum(values, 3));
    }
}
