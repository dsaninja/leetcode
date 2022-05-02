package com.dsaninja.lc.tiq.easy.others;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * <a href="https://leetcode.com/problems/pascals-triangle/">Problem-118</a>
 */
public class PascalTriangle{


    /**
     * <pre>
     *     1
     *     1 1
     *     1 2 1
     *     1 3 3 1
     * </pre>
     *
     * triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col]
     *
     * @param numRows number rof rows to be printed
     * @return first n rows of pascal triangle
     */
    public List<List<Integer>> pascalTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    @Test
    public void testPascaleTriangle(){
        assertEquals(Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(1,1),
                        Arrays.asList(1,2,1),
                        Arrays.asList(1,3,3,1),
                        Arrays.asList(1,4,6,4,1)),
                pascalTriangle(5));
    }
}
