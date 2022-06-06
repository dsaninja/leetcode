package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them
 * with no order requirement. You could assume there always exists an answer.
 *
 * <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists/">Problem-599</a>
 */
public class MinIndexSum{
    public String[] findRestaurant(String[] list1, String[] list2){
        Map<String, Integer> one = new HashMap<>();
        List<String> res = new ArrayList<>();

        int index = 0;
        // populate the index cache for
        // all restaurant
        for(String rst : list1){
            one.put(rst, index++);
        }

        int minSum = Integer.MAX_VALUE;

        // if any rest is present in the first list
        for(int i = 0; i < list2.length; i++){
            if(one.containsKey(list2[i])){
                // check if the sum is minimum
                if(minSum > i + one.get(list2[i])){
                    // if yes, clear the existing result list and add
                    // this one with min index sum
                    res.clear();
                    res.add(list2[i]);
                    // update min sum
                    minSum = i + one.get(list2[i]);
                } else if(minSum == i + one.get(list2[i])){
                    // otherwise simply add to consider duplicates
                    // with same minSum
                    res.add(list2[i]);
                }
            }
        }

        // return
        return res.toArray(new String[0]);

    }

    @Test
    public void testFind(){
        assertArrayEquals(new String[]{"Shogun"},
                findRestaurant(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
    }
}
