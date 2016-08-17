package com.javaee.collections.mod1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Den on 14.08.2016.
 *
 * dry
 * don't repeat yourself
 */
public class SetOperationEfficiency {

    public static Random random = new Random();

    public static long countTimeAdd(Set set){
        int element = random.nextInt(set.size());
        long currentTimeMillis = System.currentTimeMillis();
        set.add(element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeRemove(Set set){
        int indexElement = random.nextInt(set.size());
        long currentTimeMillis = System.currentTimeMillis();
        set.remove(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeContains(Set set){
        int value = random.nextInt(set.size());
        long currentTimeMillis = System.currentTimeMillis();
        set.contains(value);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimePopulate(Set<Integer> set){
        Set<Integer> collection = IntStream.range(0, 100).boxed().collect(Collectors.toSet());
        long currentTimeMillis = System.currentTimeMillis();
        collection.addAll(set);
        return System.currentTimeMillis() - currentTimeMillis;
    }



    public static String efficiencySetOperation(Set<Integer> set){
        int numberRepetitions = 100;

        List<Double> collect = Stream.<Function<Set<Integer>, Long>>of(SetOperationEfficiency::countTimeAdd,
                SetOperationEfficiency::countTimeRemove,
                SetOperationEfficiency::countTimeContains,
                SetOperationEfficiency::countTimePopulate)
                .map(f -> countAverage(set, numberRepetitions, f))
                .collect(Collectors.toList());

        String collectionClassName = set.getClass().getSimpleName();

        return String.format("%-15s%-10.2f%-12.2f%-15.2f",collectionClassName
                ,collect.get(0),collect.get(1),collect.get(2),collect.get(3));
    }

    public static double countAverage(Set<Integer> set, int times, Function<Set<Integer>, Long> function){
        long[] array = LongStream.generate(() -> function.apply(set)).limit(times).toArray();
        return Arrays.stream(array).average().orElse(0);
    }
}
