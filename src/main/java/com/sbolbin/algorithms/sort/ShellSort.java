package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.utils.Utils.*;

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
}
