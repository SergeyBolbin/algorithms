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

    public static void main(String[] args) {
        Integer[] arr = {2, 6, 5, 3, 7, 1, 0, 4, 9, 8};
        print(arr);
        shuffle(arr);
        print(arr);
    }
}


