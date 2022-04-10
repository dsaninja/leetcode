package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are keeping score for a baseball game with strange rules. The game consists
 * of several rounds, where the scores of past rounds may affect future rounds' scores.
 * <p>
 * At the beginning of the game, you start with an empty record. You are given a list
 * of strings ops, where ops[i] is the ith operation you must apply to the record and is
 * one of the following:
 * <ol>
 *  <li>An integer x - Record a new score of x.</li>
 *  <li>"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.</li>
 *  <li>"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.</li>
 *  <li>"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.</li>
 * </ol>
 * <p>
 * Return the sum of all the scores on the record.
 * <p>
 * https://leetcode.com/problems/baseball-game/
 */
public class BaseballGame{
    public static int calPoints(String[] ops){
        Stack<Integer> queue = new Stack<>();

        for(String op : ops){
            switch(op){
                case "C" -> queue.pop();
                case "D" -> queue.add(2 * queue.peek());
                case "+" -> {
                    int curr = queue.pop();
                    int result = curr + queue.peek();
                    queue.add(curr);
                    queue.add(result);
                }
                default -> queue.add(Integer.parseInt(op));
            }
        }

        return queue.stream().mapToInt(Integer::intValue).sum();
    }

    @Test
    public void testScore(){
        assertEquals(30, calPoints(new String[]{"5","2","C","D","+"}));
    }
}
