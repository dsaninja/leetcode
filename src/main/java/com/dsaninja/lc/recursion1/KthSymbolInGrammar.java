package com.dsaninja.lc.recursion1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * We build a table of n rows (1-indexed). We start by writing
 * 0 in the 1st row. Now in every subsequent row, we look at
 * the previous row and replace each occurrence of 0 with 01,
 * and each occurrence of 1 with 10.
 * <p>
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01,
 * and the 3rd row is 0110.
 * <p>
 * Given two integer n and k, return the kth (1-indexed) symbol in
 * the nth row of a table of n rows.
 *
 * <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">Problem=779</a>
 * <a href="https://www.youtube.com/watch?v=QRa9ZVGMWlY">YouTube</a>
 */
public class KthSymbolInGrammar{
    /**
     * <h1>Problem as a tree</h1>
     * Consider the following example tree:
     * <pre>
     *              0
     *         0           1
     *       0    1     1     0
     *      0 1  1 0   1 0   0 1
     * </pre>
     *
     * <h1>Observation:</h1>
     *
     * The k<sup>th</sup> element in the nth row is dependent on the
     * following two:
     * <ol>
     *     <li>value of its parent in n-1<sup>th</sup> row; P0-> 0,1 and P1->1,0</li>
     *     <li>its position in nth row; as every parent has two possible children 0 or 1</li>
     * </ol>
     *
     * As clearly visible from the above tree:
     * <ol>
     *  <li>If parent is 0:</li>
     *     <ol>
     *      <li>for even value of k -> 0</li>
     *      <li>for odd value of k -> 1</li>
     *     </ol>
     *  <li>If parent is 1:</li>
     *     <ol>
     *       <li>for even value of k -> 1</li>
     *       <li>for odd value of k -> 0</li>
     *     </ol>
     * </ol>
     *
     * <h1>How to calculate the parent value?</h1>
     * Consider the following rows:
     *
     * <pre>
     *     row(n-1) -> k=1        k=2      k=3
     *     row(n) -> k=1, k=2, k=3, k=4,  k=5, k=6
     * </pre>
     *
     * We can see that parent for k in row n can be found
     * as <code>round(k/2)</code> position in row <code>n-1</code>:
     * <pre>
     * 1 -> round(1/2) -> 1
     * 2 -> round(2/2) -> 1
     * 3 -> round(3/2) -> 2
     * 4 -> round(4/2) -> 2
     * 5 -> round(5/2) -> 3
     * 6 -> round(6/2) -> 3
     * </pre>
     *
     * @param n row number
     * @param k position in n<sup>th</sup> row
     * @return k<sup>th</sup> value in n<sup>th</sup> row
     */
    public int kthGrammar(int n, int k) {
        // base case for 1st row
        if(n == 1){
            return 0;
        }

        // The parent will be in n-1 row and at Math.ciel(k/2) location
        int parent = kthGrammar(n-1, (int)Math.round((double) k/ 2));
        boolean even = (k & 1) == 0;

        if(parent == 1){
            return even ? 0 : 1;
        }else{
            return even ? 1 : 0;
        }
    }

    @Test
    public void testGrammar(){
        assertEquals(1,kthGrammar(30, 417219134));
    }
}
