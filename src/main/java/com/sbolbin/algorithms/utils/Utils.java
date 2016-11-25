package com.sbolbin.algorithms.utils;

public final class Utils {

    private Utils() {
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static Comparable[] exchange(Comparable[] arr, int i, int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
        return arr;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i < hi - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static void print(Comparable[] arr) {
        for (Comparable item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T> void insertAtPosition(T[] arr, int pos, int size, T val) {
        System.arraycopy(arr, pos, arr, pos + 1, size - pos);
        arr[pos] = val;
    }

    public static <T> void shiftToTheLeft(T[] arr, int pos, int size) {
        System.arraycopy(arr, pos + 1, arr, pos, size - 1 - pos);
        arr[size - 1] = null;
    }
}
