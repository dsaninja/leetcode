package com.dsaninja.lc.recursion1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * <pre>
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * </pre>
 *
 * <a href="https://leetcode.com/problems/pascals-triangle-ii/">Problem-119</a>
 */
public class PascalTriangleII{
    public List<Integer> getRow(int rowIndex){
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Arrays.asList(1));

        // first row already added so index start from 2
        // till rowIndex
        for(int rowNum = 2; rowNum <= rowIndex; rowNum++){
            List<Integer> prev = rows.get(rows.size() - 1);
            List<Integer> row = new ArrayList<>();

            // first element is always 1
            row.add(1);

            // as we need top and top-1 values
            // start inner loop from 1 (to include 0
            // index from prev row)
            // this will go till rowNum - 2 like for 2nd row
            // this loop should not anything
            for(int j =1; j < rowNum-1; j++){
                row.add(prev.get(j) + prev.get(j-1));
            }

            // last element is always 1
            row.add(1);

            // add row to rows
            rows.add(row);
        }

        return rows.get(rowIndex-1);
    }

    public List<Integer> getRowRec(int rowIndex){
        return rec(Arrays.asList(1), rowIndex-1);
    }

    private List<Integer> rec(List<Integer> asList, int rowIndex){
        if(rowIndex == 0){
            return asList;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for(int i=1; i < asList.size(); i++){
            row.add(asList.get(i) + asList.get(i-1));
        }
        row.add(1);

        return rec(row, rowIndex-1);
    }

    @Test
    public void testPascalTriangle(){
        assertEquals(Arrays.asList(1), getRow(1));
        assertEquals(Arrays.asList(1,1), getRow(2));
        assertEquals(Arrays.asList(1,2,1), getRow(3));
        assertEquals(Arrays.asList(1,3,3,1), getRow(4));
        assertEquals(Arrays.asList(1,4,6,4,1), getRow(5));
    }

    @Test
    public void testPascalTriangleRec(){
        assertEquals(Arrays.asList(1), getRowRec(1));
        assertEquals(Arrays.asList(1,1), getRowRec(2));
        assertEquals(Arrays.asList(1,2,1), getRowRec(3));
        assertEquals(Arrays.asList(1,3,3,1), getRowRec(4));
        assertEquals(Arrays.asList(1,4,6,4,1), getRowRec(5));
    }
}
