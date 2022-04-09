package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the
 * kth distinct element.
 */
public class KthLargestElement{

    // Take min Heap to hold k elements. in this way top element of heap will
    // give the kth largest element.
    // keep maintaining heap of size k on add method call.
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public void init(int k, int[] nums){
        this.k = k;

        // say we have elements 1,2,3,4 and we want to fetch k = 2 highest element
        // pq = 1
        // pq = 1,2
        // pq = 1,2,3 but now pq size > k so pop 1 => pq = 2,3
        // pq = 2,3,4 but now pq size > k so pop 2 => pq = 3, 4
        // now return top of pq which is now kth largest element

        for(int i : nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val){
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    @Test
    @DisplayName("test kth largest element")
    public void testKthLargestElement(){
        init(3, new int[]{4, 5, 8, 2});
        assertEquals(4, add(3));
        assertEquals(5, add(5));
        assertEquals(5, add(10));
        assertEquals(8, add(9));
        assertEquals(8, add(4));
    }
}
