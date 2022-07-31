package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal
 * stack (push, top, pop, and empty).
 *
 * <a href="https://leetcode.com/problems/implement-stack-using-queues/">Problem-225</a>
 */
public class StackUsingQueue{

    private final Queue<Integer> primary;
    private final Queue<Integer> secondary;

    public StackUsingQueue(){
        primary = new LinkedList<>();
        secondary = new LinkedList<>();
    }

    public void push(int x) {
        if(primary.isEmpty()){
            primary.add(x);
        }else {
            while(!primary.isEmpty()){
                secondary.add(primary.remove());
            }
            primary.add(x);
            while(!secondary.isEmpty()){
                primary.add(secondary.remove());
            }
        }
    }

    public int pop() {
        return primary.isEmpty() ? Integer.MIN_VALUE : primary.poll();
    }

    public int top() {
        return primary.isEmpty() ? Integer.MIN_VALUE : primary.peek();
    }

    public boolean empty() {
        return primary.isEmpty();
    }

    @Test
    public void testStack(){
        StackUsingQueue myStack = new StackUsingQueue();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        assertFalse(myStack.empty());
    }
}
