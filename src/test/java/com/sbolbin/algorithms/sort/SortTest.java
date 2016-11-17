package com.sbolbin.algorithms.sort;

import org.junit.Test;

import static com.sbolbin.algorithms.sort.Utils.isSorted;
import static com.sbolbin.algorithms.sort.Utils.print;

public class SortTest {

    private Integer[] arr = {2, 6, 5, 3, 7, 1, 0, 4, 9, 8};

    @Test
    public void insertionSortTest() {
        Integer[] arrayToSort = arr.clone();
        InsertionSort.sort(arrayToSort);
        print(arrayToSort);
        assert isSorted(arrayToSort);
    }

    @Test
    public void selectionSortTest() {
        Integer[] arrayToSort = arr.clone();
        SelectionSort.sort(arrayToSort);
        print(arrayToSort);
        assert isSorted(arrayToSort);
    }

    @Test
    public void shellSortTest() {
        Integer[] arrayToSort = arr.clone();
        ShellSort.sort(arrayToSort);
        print(arrayToSort);
        assert isSorted(arrayToSort);
    }

    @Test
    public void mergeSortTest() {
        Integer[] arrayToSort = arr.clone();
        MergeSort.sort(arrayToSort);
        print(arrayToSort);
        assert isSorted(arrayToSort);
    }

    @Test
    public void quickSortTest() {
        Integer[] arrayToSort = arr.clone();
        QuickSort.sort(arrayToSort);
        print(arrayToSort);
        assert isSorted(arrayToSort);
    }


    @Test
    public void partitionTest() {
        Integer[] arrayToSort = arr.clone();
        int j = QuickSort.partition(arrayToSort, 0, arrayToSort.length - 1);
        print(arrayToSort);
        System.out.println(j);
        for (int i = 0; i < j; i++) {
            assert arrayToSort[i] <= arrayToSort[j];
        }

        for (int i = j; i < arrayToSort.length; i++) {
            assert arrayToSort[i] >= arrayToSort[j];
        }
    }

    @Test
    public void shufflingTest() {
        Integer[] arrayToShuffle = arr.clone();
        Shuffling.shuffle(arrayToShuffle);
        print(arrayToShuffle);
    }
}
