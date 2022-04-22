package com.dsaninja.lc.tiq.easy.sands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2
 * respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged, and the
 * last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 *
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Problem-88</a>
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length -1;

        // i and j  are pointing to respective array ends
        int i = m - 1, j = n - 1;

        // start from right till beginning of array
        while (index >= 0){
            if(j < 0){
                break;
            }

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }

    @Test
    public void testSortedMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);

        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }
}
