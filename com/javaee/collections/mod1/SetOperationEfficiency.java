package com.javaee.collections.mod1;

import java.util.*;

/**
 * Created by Den on 14.08.2016.
 */
public class SetOperationEfficiency {

    public static Set initSet(Set set, int countOperation){
        Random random = new Random();
        int element;
        for(int i = 0; i < countOperation; i++){
            element = random.nextInt(countOperation);
            set.add(element);
        }
        return set;
    }

    public static long countTimeAdd(Set set, int countOperation){
        Random random = new Random();
        int element = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        set.add(element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeRemove(Set set, int countOperation){
        Random random = new Random();
        int indexElement = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        set.remove(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeContains(Set set, int countOperation){
        Random random = new Random();
        int value = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        set.contains(value);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimePopulate(Set set, int countOperation){
        Random random = new Random();
        int countElemets = random.nextInt(countOperation);
        Set<Integer> collection = new HashSet<>(countElemets);
        for(int i = 0; i < 100; i++){
            collection.add(i);
        }
        long currentTimeMillis = System.currentTimeMillis();
        collection.addAll(set);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static String efficiencySetOperation(Set set, int countElements){
        double[] resultSet = new double[4];
        int numberRepetitions = 100;
        long[] times = new long[numberRepetitions];

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeAdd(set,countElements);
        }
        resultSet[0] = Arrays.stream(times).average().getAsDouble();

       for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeRemove(set,countElements);
        }
        resultSet[1] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeContains(set,countElements);
        }
        resultSet[2] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimePopulate(set,countElements);
        }
        resultSet[3] = Arrays.stream(times).average().getAsDouble();

       String s = set.getClass().toString();
       String setName = s.substring(s.lastIndexOf(".")+1);

        return String.format("%-15s%-10.2f%-12.2f%-15.2f%-15.2f",setName
                ,resultSet[0],resultSet[1],resultSet[2],resultSet[3]);
    }


}
