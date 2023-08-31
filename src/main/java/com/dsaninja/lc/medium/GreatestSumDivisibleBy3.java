package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, return the maximum possible
 * sum of elements of the array such that it is divisible by three.
 *
 * <a href="https://leetcode.com/problems/greatest-sum-divisible-by-three/">Problem-1262</a>
 */
public class GreatestSumDivisibleBy3 {

    @Test
    @DisplayName("test greatest sum divisible by 3")
    public void test(){
        assertEquals(18, maxSumDivThree(new int[]{3,6,5,1,8}));
        assertEquals(0, maxSumDivThree(new int[]{4}));
        assertEquals(12, maxSumDivThree(new int[]{1,2,3,4,4}));
    }

    /**
     * Approach copied from <a href="https://leetcode.com/problems/greatest-sum-divisible-by-three/solutions/1055939/java-simple-one-pass-easy-solution-with-explanation/">here</a>
     *
     * <ol>
     *     <li>Sum all the elements</li>
     *     <li>If {@code sum % 3 == 0} it is maximum</li>
     *     <li>if {@code sum % 3 == 1} we can delete smallest element such that {@code x%3 == 1} or we can delete 2 smallest elements such that {@code x % 3 == 2}. <strong>We delete which ever is smallest</strong>. eg -> {@code [2,6,2,2,7]} we can delete {@code [7]} because it is smallest element with {@code mod%3==1} or {@code [2,2]} because {@code mod = 4 % 3 = 1}. We delete {@code [2,2]} as {@code 4 < 7}</li>
     *     <li>Similarly if {@code sum % 3 == 2} we can delete smallest element such that {@code x%3 == 2} or we can delete 2 smallest elements such that {@code x % 3 == 1}. <strong>We delete which ever is smallest.</strong></li>
     * </ol>
     *
     * @param nums to be analysed
     * @return max sum
     */
    public int maxSumDivThree(int[] nums) {
        int smallestMod1 = 10001;
        int scndSmallestMod1 = 10001;

        int smallestMod2 = 10002;
        int scndSmallestMod2 = 10002;

        int sum = 0;

        for(int element : nums){
            sum+= element;

            if(element % 3 == 1){
                if(element <= smallestMod1){
                    scndSmallestMod1 = smallestMod1;
                    smallestMod1 = element;
                }else if(element < scndSmallestMod1){
                    scndSmallestMod1 = element;
                }
            }

            if(element % 3 == 2){
                if(element <= smallestMod2){
                    scndSmallestMod2 = smallestMod2;
                    smallestMod2 = element;
                }else if(element < scndSmallestMod2){
                    scndSmallestMod2 = element;
                }
            }
        }

        if(sum % 3 == 0){
            return sum;
        }else if(sum % 3 == 1){
            return sum - Math.min(smallestMod1, smallestMod2 + scndSmallestMod2);
        }else{
            return sum - Math.min(smallestMod2, smallestMod1 + scndSmallestMod1);
        }
    }
}
