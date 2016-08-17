package com.javaee.collections.mod1;

import java.io.IOException;

/**
 * Created by Den on 18.08.2016.
 */
public class Runner {
    public static void main(String[] args)throws IOException {
        CollectionsWtiter collectionsEfficiency = new CollectionsWtiter();
        int[] elements = {10000, 100000, 1000000};

        for (int i = 0; i < elements.length; i++){
            collectionsEfficiency.printAndWriteFile(elements[i]);
        }
    }
}
