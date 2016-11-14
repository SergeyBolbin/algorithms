package com.sbolbin.algorithms.structures;

public class QueueTest {

    public static void main(String[] args) {
        int size = 1000;
        testQueueImpl(new LinkedQueue<>(), size);
        testQueueImpl(new ArrayQueue<>(), size);

    }

    private static void testQueueImpl(Queue<Integer> queue, int size) {

        System.out.println();
        System.out.println("--------------------");


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

        assert sb1.toString().equals(sb2.toString());

        System.out.println(sb1.toString());
        System.out.println("--------------------");
    }
}
