package com.javaee.collections.mod1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectionsEfficiency {

    public void printAndWriteFile(int countElements) throws IOException {

       // final File result = new File("src\\result.txt");
       // FileWriter fileWriter = new FileWriter(result,true);

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

    /*    String title = String.format("%-15.0f%-8s%-8s%-8s%-8s%-8s%-8s%-8s",countElements
                ,"add","remove","contains","populate","get","iterator.add","iterator.remove");*/
        String line = "------------------------------------------------------------------------";
        String resultArrayList = ListOperationEfficiency.efficiencyListOperation(arrayList,countElements);
        String resultLinkedList = ListOperationEfficiency.efficiencyListOperation(linkedList,countElements);
        String resultHashSet = SetOperationEfficiency.efficiencySetOperation(hashSet,countElements);
        String resultTreeSet = SetOperationEfficiency.efficiencySetOperation(treeSet,countElements);
        String liner2 = "========================================================================";

        System.out.println(line);
       // System.out.println(title);
        System.out.println(line);
        System.out.println(resultArrayList);
        System.out.println(resultLinkedList);
        System.out.println(resultHashSet);
        System.out.println(resultTreeSet);
        System.out.println(liner2);
        System.out.println();

        //


    }

    public static void main(String[] args)throws IOException{
        CollectionsEfficiency collectionsEfficiency = new CollectionsEfficiency();
        int[] elements = {100, 1000, 10000};

        for (int i = 0; i < elements.length; i++){
            collectionsEfficiency.printAndWriteFile(elements[i]);
        }
    }
}
