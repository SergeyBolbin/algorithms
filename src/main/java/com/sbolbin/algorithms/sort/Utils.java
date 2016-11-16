package com.sbolbin.algorithms.sort;

final class Utils {

    private Utils() {
    }

    @SuppressWarnings("unchecked")
    static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    static Comparable[] exchange(Comparable[] arr, int i, int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
        return arr;
    }

    static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i < hi - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    static void print(Comparable[] arr) {
        for (Comparable item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
