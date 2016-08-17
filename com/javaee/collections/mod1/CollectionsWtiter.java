package com.javaee.collections.mod1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectionsWtiter {

    public void printAndWriteFile(int countElements) throws IOException {

       final File result = new File("src\\result.txt");
       FileWriter fileWriter = new FileWriter(result,true);

        List<Integer> arrayList = new ArrayList<>();
        CollectionsHelper.initCollection(arrayList,countElements);
        List<Integer> linkedList = new LinkedList<>();
        CollectionsHelper.initCollection(linkedList,countElements);
        Set<Integer> hashSet = new HashSet<>();
        CollectionsHelper.initCollection(hashSet,countElements);
        Set<Integer> treeSet = new TreeSet<>();
        CollectionsHelper.initCollection(treeSet,countElements);

        String title = String.format("%-15d%-10s%-12s%-15s%-15s%-9s%-17s%-15s",countElements
                ,"add(ms)","remove(ms)","contains(ms)","populate(ms)","get(ms)","iterator.add(ms)","iterator.remove(ms)");
        String line = "-----------------------------------------------------------------------------" +
                "-----------------------------------";
        String resultArrayList = ListOperationEfficiency.efficiencyListOperation(arrayList);
        String resultLinkedList = ListOperationEfficiency.efficiencyListOperation(linkedList);
        String resultHashSet = SetOperationEfficiency.efficiencySetOperation(hashSet);
        String resultTreeSet = SetOperationEfficiency.efficiencySetOperation(treeSet);

        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        System.out.println(resultArrayList);
        System.out.println(resultLinkedList);
        System.out.println(resultHashSet);
        System.out.println(resultTreeSet);
        System.out.println(line+"\n");

        fileWriter.write(line+"\n");
        fileWriter.write(title+"\n");
        fileWriter.write(line+"\n");
        fileWriter.write(resultArrayList+"\n");
        fileWriter.write(resultLinkedList+"\n");
        fileWriter.write(resultHashSet+"\n");
        fileWriter.write(resultTreeSet+"\n");
        fileWriter.write(line+"\n");
        fileWriter.close();
        //


    }


}
