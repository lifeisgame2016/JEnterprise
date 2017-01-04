package com.javaee.collections.mod1;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class ListOperationEfficiency {

    public static Random random = new Random();    

    public static long countTimeAdd(List list){
        int element = random.nextInt(list.size());
        int i = random.nextInt(list.size());
        long currentTimeMillis = System.currentTimeMillis();
            list.add(i,element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeGet(List list){
        int indexElement = random.nextInt(list.size());
        long currentTimeMillis = System.currentTimeMillis();
        list.get(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeRemove(List list){
        int indexElement = random.nextInt(list.size());
        long currentTimeMillis = System.currentTimeMillis();
        list.remove(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeContains(List list){
        int value = random.nextInt(list.size());
        long currentTimeMillis = System.currentTimeMillis();
        list.contains(value);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimePopulate(List<Integer> list){
        List<Integer> collection = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        long currentTimeMillis = System.currentTimeMillis();
        collection.addAll(list);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeIteratorAdd(List<Integer> list){
        ListIterator<Integer> iterator = list.listIterator();
        int element = random.nextInt(list.size());
        long currentTimeMillis = System.currentTimeMillis();
        iterator.next();
        iterator.add(element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static <T> long countTimeIteratorRemove(List<T> list){
        int index = random.nextInt(list.size());
        ListIterator iterator = list.listIterator(index);
        long currentTimeMillis = System.currentTimeMillis();
        iterator.next();
        iterator.remove();
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static String efficiencyListOperation(List<Integer> list){
        int numberRepetitions = 100;

        List<Double> collect = Stream.<Function<List<Integer>, Long>>of(ListOperationEfficiency::countTimeAdd,
                ListOperationEfficiency::countTimeGet,
                ListOperationEfficiency::countTimeRemove,
                ListOperationEfficiency::countTimeContains,
                ListOperationEfficiency::countTimePopulate,
                ListOperationEfficiency::countTimeIteratorAdd,
                ListOperationEfficiency::countTimeIteratorRemove)
                .map(f -> countAverage(list, numberRepetitions, f))
                .collect(Collectors.toList());

        String collectionClassName = list.getClass().getSimpleName();

        return String.format("%-15s%-10.2f%-12.2f%-15.2f%-15.2f%-9.2f%-17.2f%-15.2f",collectionClassName
                ,collect.get(0),collect.get(1),collect.get(3),collect.get(4),collect.get(2),collect.get(5),collect.get(6));
    }

    public static double countAverage(List<Integer> list, int times, Function<List<Integer>, Long> function){
        long[] array = LongStream.generate(() -> function.apply(list)).limit(times).toArray();
        return Arrays.stream(array).average().orElse(0);
    }
}
