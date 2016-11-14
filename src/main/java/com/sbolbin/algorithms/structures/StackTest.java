package com.sbolbin.algorithms.structures;

public class StackTest {

    public static void main(String[] args) {
        int size = 1000;
        testStackImpl(new LinkedStack<>(), size);
        testStackImpl(new ArrayStack<>(), size);

    }

    private static void testStackImpl(Stack<Integer> stack, int size) {

        System.out.println();
        System.out.println("--------------------");


        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            sb1.append(stack.pop());
            sb1.append(' ');
        }

        System.out.println();

        for (int i = size - 1; i >= 0; i--) {
            stack.push(i);
            sb2.append(stack.pop());
            sb2.append(' ');
        }

        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }

        for (Integer element : stack) {
            sb3.append(element);
            sb3.append(' ');
        }

        if (!sb1.toString().equals(sb2.toString())) throw new AssertionError();
        if (!sb1.toString().equals(sb3.toString())) throw new AssertionError();

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());
        System.out.println("--------------------");


    }

}
