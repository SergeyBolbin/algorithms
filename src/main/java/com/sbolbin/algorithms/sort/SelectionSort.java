package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.utils.Utils.*;

public class SelectionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }
}
