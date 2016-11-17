package com.sbolbin.algorithms.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private final static int size = 1000;

    @Test
    public void testLinkedQueue() {
        testQueueImpl(new LinkedQueue<>(), size);
    }

    @Test
    public void testArrayQueue() {
        testQueueImpl(new ArrayQueue<>(), size);
    }

    private void testQueueImpl(Queue<Integer> queue, int size) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            sb1.append(queue.dequeue());
            sb1.append(' ');
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
            sb2.append(queue.dequeue());
            sb2.append(' ');
        }

        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        for (Integer elem : queue) {
            sb3.append(elem);
            sb3.append(' ');
        }


        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

        assertEquals(sb1.toString(), sb2.toString());
        assertEquals(sb1.toString(), sb3.toString());
    }

}
