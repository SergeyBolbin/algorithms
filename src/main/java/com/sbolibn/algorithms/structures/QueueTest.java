package com.sbolibn.algorithms.structures;

public class QueueTest {

    public static void main(String[] args) {
        //testQueueImpl(new LinkedQueue(), 1000);
        testQueueImpl(new ArrayQueue(), 10);

    }

    private static void testQueueImpl(Queue queue, int size) {

        System.out.println();
        System.out.println("--------------------");


        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < size; i++) {
            queue.enqueue(" " + i);
        }

        while (!queue.isEmpty()) {
            sb1.append(queue.dequeue());
        }

        System.out.println();

        for(int i = 0; i < size; i++) {
            queue.enqueue(" " + i);
            sb2.append(queue.dequeue());
        }

        assert sb1.toString().equals(sb2.toString());

        System.out.println(sb1.toString());
        System.out.println("--------------------");
    }
}
