package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.sort.Utils.*;

public class ShellSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exchange(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 6, 5, 3, 7, 1, 0, 4, 9, 8};
        sort(arr);

        if (!isSorted(arr)) throw new AssertionError();
        print(arr);
    }
}
