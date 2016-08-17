package com.javaee.collections.mod1;


import java.util.*;


public class ListOperationEfficiency {

    public static List initList(List list, int countOperation){
        Random random = new Random();
        int element;
        for(int i = 0; i < countOperation; i++){
            element = random.nextInt(countOperation);
            list.add(element);
        }
        return list;
    }

    public static long countTimeAdd(List list, int countOperation){
        Random random = new Random();
        int element = random.nextInt(countOperation);
        int i = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
            list.add(i,element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeGet(List list, int countOperation){
        Random random = new Random();
        int indexElement = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        list.get(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeRemove(List list, int countOperation){
        Random random = new Random();
        int indexElement = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        list.remove(indexElement);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeContains(List list, int countOperation){
        Random random = new Random();
        int value = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        list.contains(value);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimePopulate(List list, int countOperation){
        Random random = new Random();
        int countElemets = random.nextInt(countOperation);
        List<Integer> collection = new ArrayList<>(countElemets);
        for(int i = 0; i < 100; i++){
            collection.add(i);
        }
        long currentTimeMillis = System.currentTimeMillis();
        collection.addAll(list);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeIteratorAdd(List list, int countOperation){
        ListIterator iterator = list.listIterator();
        Random random = new Random();
        int element = random.nextInt(countOperation);
        long currentTimeMillis = System.currentTimeMillis();
        iterator.next();
        iterator.add(element);
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static long countTimeIteratorRemove(List list, int countOperation){
        Random random = new Random();
        int index = random.nextInt(countOperation);
        ListIterator iterator = list.listIterator(index);
        long currentTimeMillis = System.currentTimeMillis();
        iterator.next();
        iterator.remove();
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static String efficiencyListOperation(List list, int countElements){
        double[] resultArray = new double[7];
        int numberRepetitions = 100;
        long[] times = new long[numberRepetitions];

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeAdd(list,countElements);
        }
        resultArray[0] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeGet(list,countElements);
        }
        resultArray[1] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeRemove(list,countElements);
        }
        resultArray[2] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeContains(list,countElements);
        }
        resultArray[3] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimePopulate(list,countElements);
        }
        resultArray[4] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeIteratorAdd(list,countElements);
        }
        resultArray[5] = Arrays.stream(times).average().getAsDouble();

        for(int i = 0; i < numberRepetitions; i++){
            times[i] = countTimeIteratorRemove(list,countElements);
        }
        resultArray[6] = Arrays.stream(times).average().getAsDouble();

        String s = list.getClass().toString();
        String setName = s.substring(s.lastIndexOf(".")+1);

        return String.format("%-15s%-10.2f%-12.2f%-15.2f%-15.2f%-9.2f%-17.2f%-15.2f",setName
                ,resultArray[0],resultArray[1],resultArray[3],resultArray[4],resultArray[2],resultArray[5],resultArray[6]);
    }






}
