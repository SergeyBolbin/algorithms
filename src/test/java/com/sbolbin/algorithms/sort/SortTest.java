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
    public void shufflingTest() {
        Integer[] arrayToShuffle = arr.clone();
        Shuffling.shuffle(arrayToShuffle);
        print(arrayToShuffle);
    }
}
