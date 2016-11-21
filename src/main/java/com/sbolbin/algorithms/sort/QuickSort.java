package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.utils.Utils.exchange;
import static com.sbolbin.algorithms.utils.Utils.less;

public class QuickSort {

    public static void sort(Comparable[] arr) {
        Shuffling.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, 0, j - 1);
        sort(arr, j + 1,  hi);
    }

    public static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {
            while (less(arr[++i], arr[lo]))
                if (i == hi) break;

            while (less(arr[lo], arr[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exchange(arr, i, j);
        }

        exchange(arr, j, lo);
        return j;
    }
}
