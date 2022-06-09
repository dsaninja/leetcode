package com.dsaninja.lc.recursionI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        rows.add(List.of(1));

        // first row already added so index start from 2
        // till rowIndex
        for(int rowNum = 1; rowNum <= rowIndex; rowNum++){
            List<Integer> prev = rows.get(rows.size() - 1);
            List<Integer> row = new ArrayList<>();

            // first element is always 1
            row.add(1);

            // as we need top and top-1 values
            // start inner loop from 1 (to include 0
            // index from prev row)
            for(int j =1; j < rowNum; j++){
                row.add(prev.get(j) + prev.get(j-1));
            }

            // last element is always 1
            row.add(1);

            // add row to rows
            rows.add(row);
        }

        return rows.get(rowIndex);
    }


    record RowCol(int row, int col){}
    private final Map<RowCol, Integer> cache = new HashMap<>();

    public List<Integer> getRowViaCache(int rowIndex){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            result.add(getOrCalculate(rowIndex, i));
        }

        return result;
    }

    private int getOrCalculate(int row, int col){
        RowCol rowCol = new RowCol(row, col);
        if(cache.containsKey(rowCol)){
            return cache.get(rowCol);
        }

        if(row == 0 || col ==0 || row == col){
            return 1;
        }

        int result = getOrCalculate(row-1, col-1) + getOrCalculate(row-1, col);
        cache.put(rowCol, result);

        return result;
    }


    // *********** time limit exceeds ************
    public List<Integer> getRowRec(int rowIndex){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            result.add(calculate(rowIndex, i));
        }

        return result;
    }

    private int calculate(int row, int col){
        if(row == 0 || col ==0 || row == col){
            return 1;
        }

        return calculate(row-1, col-1) + calculate(row-1, col);
    }
    // *********** time limit exceeds ************

    @Test
    public void testPascalTriangle(){
        assertEquals(Arrays.asList(1), getRow(0));
        assertEquals(Arrays.asList(1,1), getRow(1));
        assertEquals(Arrays.asList(1,2,1), getRow(2));
        assertEquals(Arrays.asList(1,3,3,1), getRow(3));
        assertEquals(Arrays.asList(1,4,6,4,1), getRow(4));
    }

    @Test
    public void testPascalTriangleRec(){
        assertEquals(Arrays.asList(1), getRowRec(0));
        assertEquals(Arrays.asList(1,1), getRowRec(1));
        assertEquals(Arrays.asList(1,2,1), getRowRec(2));
        assertEquals(Arrays.asList(1,3,3,1), getRowRec(3));
        assertEquals(Arrays.asList(1,4,6,4,1), getRowRec(4));
    }

    @Test
    public void testPascalTriangleCached(){
        assertEquals(Arrays.asList(1), getRowViaCache(0));
        assertEquals(Arrays.asList(1,1), getRowViaCache(1));
        assertEquals(Arrays.asList(1,2,1), getRowViaCache(2));
        assertEquals(Arrays.asList(1,3,3,1), getRowViaCache(3));
        assertEquals(Arrays.asList(1,4,6,4,1), getRowViaCache(4));
    }
}
