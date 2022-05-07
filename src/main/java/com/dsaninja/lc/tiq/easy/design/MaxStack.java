package com.dsaninja.lc.tiq.easy.design;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Followup question to min stack problem
 */
public class MaxStack{
    private final Stack<Integer> stack;
    private final Stack<Map.Entry<Integer, Integer>> maxTracker;

    public MaxStack(){
        stack = new Stack<>();
        maxTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(maxTracker.empty() || val > maxTracker.peek().getKey()){
            maxTracker.push(Map.entry(val, 1));
        }else if(maxTracker.peek().getKey() == val){
            Map.Entry<Integer, Integer> pop = maxTracker.pop();
            maxTracker.push(Map.entry(pop.getKey(), pop.getValue() + 1));
        }
    }

    public int top(){
        return stack.peek();
    }

    public void pop(){
        int pop = stack.pop();

        if(pop == maxTracker.peek().getKey()){
            Map.Entry<Integer, Integer> max = maxTracker.pop();
            if(max.getValue() > 1){
                maxTracker.push(Map.entry(max.getKey(), max.getValue() - 1));
            }
        }

    }

    public int getMax(){
        return maxTracker.peek().getKey();
    }

    @Test
    public void testMaxStack(){
        MaxStack minStack = new MaxStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertEquals(0, minStack.getMax());

        minStack.pop();

        assertEquals(0, minStack.top());
        assertEquals(0, minStack.getMax());

        minStack.pop();
        assertEquals(-2, minStack.getMax());
        assertEquals(-2, minStack.top());
    }
}
