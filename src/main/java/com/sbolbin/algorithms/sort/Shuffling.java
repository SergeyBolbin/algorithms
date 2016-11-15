package com.sbolbin.algorithms.sort;

import java.util.Random;

import static com.sbolbin.algorithms.sort.Utils.*;

public class Shuffling {

    public static void shuffle(Comparable[] arr) {
        Random random = new Random();
        for (int i = 1; i < arr.length; i++) {
            int rnd = random.nextInt(i);
            exchange(arr, i, rnd);
        }
    }
}


