package com.javaee.collections.mod1;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;


public class CollectionsHelper {


    public static void initCollection(Collection<Integer> collection, int capacity){
        Random random = new Random();
        Stream.generate(random::nextInt).limit(capacity).forEach(collection::add);
    }
}
