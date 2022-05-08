package com.dsaninja.lc.arrays101;

/**
 * You are given two integer arrays nums1 and nums2, sorted in
 * non-decreasing order, and two integers m and n, representing
 * the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing
 * order.
 * <p>
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1. To accommodate this,
 * nums1 has a length of m + n, where the first m elements denote the
 * elements that should be merged, and the last n elements are set to
 * 0 and should be ignored. nums2 has a length of n.
 *
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Problem-88</a>
 */
public class MergeSortedArrays{

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        // if any one of the arrays is blank, return
        if(nums1.length == 0 || nums2.length == 0) return;
        int indexOne = 0;

        while(indexOne < m){
            // always compare ith element from
            // first array with first element of 2nd array
            if(nums1[indexOne] > nums2[0]){

                // if out of order, swap the two
                int temp = nums1[indexOne];
                nums1[indexOne] = nums2[0];
                nums2[0] = temp;

                int indexTwo = 1;
                // after swapping, move the new element
                // to its correct position in 2nd array
                while(indexTwo < n && nums2[indexTwo] < nums2[indexTwo - 1]){
                    temp = nums2[indexTwo];
                    nums2[indexTwo] = nums2[indexTwo - 1];
                    nums2[indexTwo -1] = temp;
                    indexTwo++;
                }
            }
            indexOne++;
        }

        // copy array 2 in 1
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int maxValueIndexInFirstArray = m-1;
        int maxValueIndexInSecondArray = n-1;

        int maxValueIndexInResult = nums1.length -1;

        // starting from the end of result i.e. nums1 array
        while(maxValueIndexInResult >= 0){

            // the below-mentioned else condition simply
            // decrements the variable by 1, so before
            // we check anything, lets first validate the index
            if(maxValueIndexInSecondArray < 0){
                break;
            }

            // if last value in array1 is greater than last value in second array
            if(maxValueIndexInFirstArray >= 0 && nums1[maxValueIndexInFirstArray] > nums2[maxValueIndexInSecondArray]){
                // use that one and reduce corresponding index.
                nums1[maxValueIndexInResult] = nums1[maxValueIndexInFirstArray];
                maxValueIndexInFirstArray--;
            }else{
                // else use value from array2 and reduce its index
                nums1[maxValueIndexInResult] = nums2[maxValueIndexInSecondArray];
                maxValueIndexInSecondArray--;
            }

            maxValueIndexInResult--;
        }
    }
}
