package com.sbolbin.algorithms.structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    private static final int size = 1000;

    @Test
    public void testLinkedStack() {
        testStackImpl(new LinkedStack<>(), size);
    }

    @Test
    public void testArrayStack() {
        testStackImpl(new ArrayStack<>(), size);
    }

    private void testStackImpl(Stack<Integer> stack, int size) {

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

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

        assertEquals(sb1.toString(), sb2.toString());
        assertEquals(sb1.toString(), sb3.toString());
    }

}
