package com.dsaninja.lc.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class QueueUsingStacks{
    private Stack<Integer> one = new Stack<>();
    private Stack<Integer> two = new Stack<>();
    private int front = 0;

    // O(1)
    public void push(int x){
        if(one.empty()){
            front = x;
        }
        one.push(x);
    }

    // amortized O(1)
    public int pop(){
        if(two.isEmpty()){
            // two once populated
            // can be re-used
            while(!one.isEmpty()){
                two.push(one.pop());
            }
        }
        return two.pop();
    }

    // O(1)
    public int peek(){
        return two.empty() ? front : two.peek();
    }

    // O(1)
    public boolean empty(){
        return two.empty() && one.empty();
    }

    @Test
    @DisplayName("test queue")
    public void testQueue(){
        push(1);
        push(2);

        assertEquals(1, peek());
        assertEquals(1, pop());
        assertFalse(empty());
    }
}
