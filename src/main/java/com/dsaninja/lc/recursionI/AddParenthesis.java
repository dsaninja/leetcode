package com.dsaninja.lc.recursionI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string expression of numbers and operators,
 * return all possible results from computing all the different
 * possible ways to group numbers and operators.
 * You may return the answer in any order.
 * <p>
 * <pre>
 *  Input: expression = "2-1-1"
 *  Output: [0,2]
 *  Explanation:
 *  ((2-1)-1) = 0
 *  (2-(1-1)) = 2
 * </pre>
 *
 * <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Problem-241</a>
 */
public class AddParenthesis{
    Map<String, List<Integer>> cache = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression){
        int length = expression.length();
        List<Integer> result = new ArrayList<>();

        if(cache.containsKey(expression)){
            return cache.get(expression);
        }

        if(length == 1){
            result.add(Integer.parseInt(expression));
            return result;
        }

        for(int i = 0; i < length; i++){
            char symbol = expression.charAt(i);

            // If character is operator then split and
            // calculate recursively
            if(symbol == '+' || symbol == '-' || symbol == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Combine all possible combination
                for(int l : left){
                    for(int r : right){
                        switch(symbol){
                            case '+' -> result.add(l + r);
                            case '-' -> result.add(l - r);
                            case '*' -> result.add(l * r);
                        }
                    }
                }
            }
        }

        // expression = "-2"
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }

        // populate cache
        cache.put(expression, result);
        return result;
    }
    
    @Test
    public void testCalc(){
        assertEquals(List.of(2,0), diffWaysToCompute("2-1-1"));
    }
}
