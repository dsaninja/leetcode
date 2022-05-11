package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an array arr of integers, check if there exists two
 * integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist/">Problem-1346</a>
 */
public class NumberAndDouble{
    public boolean checkIfExist(int[] arr) {
        Set<Integer> elements = new HashSet<>();

        for(int elem : arr){
            if((elem & 1) == 0 && elements.contains(elem/2)){
                return true;
            }else if(elements.contains(elem * 2)){
                return true;
            }

            elements.add(elem);
        }

        return false;
    }

    @Test
    public void testCheckIfExists(){
        assertTrue(checkIfExist(new int[]{10,2,5,3}));
        assertTrue(checkIfExist(new int[]{7,1,14,11}));
        assertFalse(checkIfExist(new int[]{3,1,7,11}));
    }
}
