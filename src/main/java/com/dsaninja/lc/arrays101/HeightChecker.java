package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A school is trying to take an annual photo of all the students.
 * The students are asked to stand in a single file line in non-decreasing
 * order by height. Let this ordering be represented by the integer array
 * expected where expected[i] is the expected height of the ith
 * student in line.
 *
 * You are given an integer array heights representing the current
 * order that the students are standing in. Each heights[i] is
 * the height of the ith student in line (0-indexed).
 *
 * Return the number of indices where heights[i] != expected[i].
 *
 * <a href="https://leetcode.com/problems/height-checker/">Problem-1051</a>
 */
public class HeightChecker{

    // TC: O(n*logn)
    // SC: O(n)
    public int heightCheckerWithArraySort(int[] heights) {
        int[] clone = new int[heights.length];
        for(int i = 0 ; i < heights.length; i++){
            clone[i] = heights[i];
        }

        Arrays.sort(clone);
        int count = 0;

        for(int i = 0 ; i < clone.length; i++){
            if(heights[i] != clone[i]){
                count++;
            }
        }

        return count;
    }

    // SC: O(1)
    // TC: O(100*n) ~ O(n)
    public int heightCheckerWithCountSort(int[] heights) {
        int[] heightFreq = new int[101];
        Arrays.stream(heights).forEach(elem -> heightFreq[elem]++);

        int index = 0;
        int mismatches = 0;

        // consider ex: [1,1,4,2,1,3] and heightFreq [0,3,1,1,1,0]
        //
        // freq of 3, means there are 3 students with height 1
        //
        // We start by the first element of the heights array which is 1
        // and compare it to the "index" of heightFreq array’s first non-zero element
        // which is 1. This means there is at-least 1 element (ignore 3 for now) with
        // height 1 and is in correct position. Since these match, we decrement the 3
        // in heightFreq to 2 and move to the next element in the Heights (input) array.
        //
        // It’s 1 again.
        //
        // We repeat the process and again the first non-zero index (1) matches with
        // the height element (1). This again confirms that this student is at
        // correct index. We reduce the freq by 1 again to mark that we have seen
        // 2 out of 3 1s in the original freq array.
        //
        // Moving on, the next element in the heights array is 4 but our first
        // non-zero element in the heightFreq array is still at index 1 which means that
        // this student of height 4 in the heights array is in the wrong location,
        // matter of fact, we should have seen another student of height 1
        // here, as the heightFreq array suggests.
        //
        // At this point we once again decrement the heightFreq value at index 1 from 1
        // to 0 now but this time we also increment our mismatches counter to 1 as
        // it tracks the number of students in the incorrect location.

        for(int height : heights){
            while(heightFreq[index] == 0){
                index++;
            }

            if(index != height){
                mismatches++;
            }

            heightFreq[index]--;
        }

        return mismatches;
    }

    @Test
    public void testHeightChecker(){
        assertEquals(3, heightCheckerWithCountSort(new int[]{1,1,4,2,1,3}));
    }

}
