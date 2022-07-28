package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Design a data structure that accepts a stream of integers
 * and checks if it has a pair of integers that sum up to a
 * particular value. Implement the TwoSum class:
 * <ol>
 *     <li>TwoSum() Initializes the TwoSum object, with an empty array initially.</li>
 *     <li>void add(int number) Adds number to the data structure.</li>
 *     <li>boolean find(int value) Returns true if there exists any pair
 *     of numbers whose sum is equal to value, otherwise, it returns false.</li>
 * </ol>
 *
 * <a href="https://leetcode.com/problems/two-sum-iii-data-structure-design/">Problem-170</a>
 */
public class TwoSum{

    // Use a Map to track numbers and their occurrence count.
    // Check for count > 1 if number matches difference.
    private final Map<Integer, Integer> stream;

    public TwoSum() {
        stream = new HashMap<>();
    }

    public void add(int number) {
        stream.put(number, stream.getOrDefault(number, 0)+1);
    }

    public boolean find(int value) {
        for(int num : stream.keySet()){
            int diff = value - num;
            if(stream.containsKey(diff)){
                // either diff != num
                // or if equal, then latest 2 should participate
                // [0], find 0 => return false
                // [0, 0], find 0 => return true
                if(diff != num || stream.get(diff) > 1){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testTwoSum(){
        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(4);
        ts.add(5);

        assertTrue(ts.find(8));
    }

}
