package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.sort.Utils.*;

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

    public static void main(String[] args) {
        Integer[] arr = {2, 6, 5, 3, 7, 1, 0, 4, 9, 8};
        sort(arr);

        if (!isSorted(arr)) throw new AssertionError();
        print(arr);
    }
}
