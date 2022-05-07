package com.dsaninja.lc.tiq.easy.design;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Design a stack that supports push, pop, top, and retrieving 
 * the minimum element in constant time.
 *
 * <a href="https://leetcode.com/problems/min-stack/">Problem-155</a>
 */
public class MinStack{
    private final Stack<Integer> stack;
    private final Stack<Map.Entry<Integer, Integer>> minTracker;

    public MinStack() {
        stack = new Stack<>();
        minTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minTracker.empty() || val < minTracker.peek().getKey()){
            minTracker.push(Map.entry(val, 1));
        }else if(minTracker.peek().getKey() == val){
            Map.Entry<Integer, Integer> pop = minTracker.pop();
            minTracker.push(Map.entry(val, pop.getValue() + 1));
        }
    }

    public void pop() {
        int popped = stack.pop();
        if(popped == minTracker.peek().getKey()){
            Map.Entry<Integer, Integer> pop = minTracker.pop();
            if(pop.getValue() > 1){
                minTracker.push(Map.entry(pop.getKey(), pop.getValue() - 1));
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minTracker.peek().getKey();
    }
    
    @Test
    public void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        assertEquals(-3, minStack.getMin());

        minStack.pop();

        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }
}
