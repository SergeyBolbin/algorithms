package com.sbolibn.algorithms.structures;

public class StackTest {

    public static void main(String[] args) {
        testStackImpl(new LinkedStack(), 1000);
        testStackImpl(new ArrayStack(), 1000);

    }

    private static void testStackImpl(Stack stack, int size) {

        System.out.println();
        System.out.println("--------------------");


        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < size; i++) {
            stack.push(" " + i);
        }

        while (!stack.isEmpty()) {
            sb1.append(stack.pop());
        }

        System.out.println();

        for(int i = 0; i < size; i++) {
            stack.push(" " + i);
            sb2.append(stack.pop());
        }

        assert sb1.toString().equals(sb2.toString());

        System.out.println(sb1.toString());
        System.out.println("--------------------");
    }

}
