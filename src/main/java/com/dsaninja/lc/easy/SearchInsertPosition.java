package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 *
 * <a href="https://leetcode.com/problems/search-insert-position/">Problem-35</a>
 */
public class SearchInsertPosition{
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                start = mid+1;
            } else{
                end = mid - 1;
            }
        }

        // In the case where we need to insert (target not found),
        // left and right must have narrowed down to the same element - call it Elem.
        // Following regular binary search, if we go left, meaning toInsert is
        // smaller than Elem, the algorithm changes right and leaves left untouched.
        // This is desired, because left, untouched and used as insertion index,
        // inserts the element to the left of Elem. On the other hand, if we go right,
        // left is changed to left + 1, which indeed inserts target to the right of Elem.
        return start;
    }
    
    @Test
    public void testSearchInsert(){
        assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
    }
}
