package com.sbolbin.algorithms.structures;

import org.junit.Test;

public class PQTest {

    @Test
    public void testUnorderedPQ() {
        performTest(new UnorderedMaxPQ<>());
    }

    private void performTest(MaxPQ<Integer> maxPQ) {
        int[] elements = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int elem : elements) {
            maxPQ.insert(elem);
        }

        assert maxPQ.delMax() == 9;
        assert maxPQ.delMax() == 8;
        assert maxPQ.delMax() == 7;
        assert maxPQ.delMax() == 6;
        assert maxPQ.delMax() == 5;
        assert maxPQ.delMax() == 4;
        assert maxPQ.delMax() == 3;
        assert maxPQ.delMax() == 2;
        assert maxPQ.delMax() == 1;
        assert maxPQ.delMax() == 0;
        assert maxPQ.isEmpty();

    }
}
