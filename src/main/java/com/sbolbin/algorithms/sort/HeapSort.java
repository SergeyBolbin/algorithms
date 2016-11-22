package com.sbolbin.algorithms.sort;

import static com.sbolbin.algorithms.utils.Utils.exchange;
import static com.sbolbin.algorithms.utils.Utils.less;

public class HeapSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        //build heap using bottom-up method
        for (int k = n / 2; k > 0; k--) {
            sink(arr, k - 1, n - 1);
        }

        //remove the max one at time
        //leave max in array instead of nulling out
        while (n > 1) {
            int k = n - 1;
            exchange(arr, 0, k);
            sink(arr, 0, k - 1);
            n--;
        }
    }

    /**
     * Prevent violation: Parent key becomes smaller, then one or both of children
     * @param position pos
     */
    private static void sink(Comparable[] items, int position, int size) {
        int k = position;
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(items[j], items[j + 1])) j++; //neighbour, left/right children of pos
            if (!less(items[k], items[j])) break; //already in-place
            exchange(items, j, k);
            k = j;
        }
    }
}
