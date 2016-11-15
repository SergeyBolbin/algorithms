package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.sort.Utils.*;

public class InsertionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 6, 5, 3, 7, 1, 0, 4, 9, 8};
        sort(arr);

        if (!isSorted(arr)) throw new AssertionError();
        print(arr);
    }
}
