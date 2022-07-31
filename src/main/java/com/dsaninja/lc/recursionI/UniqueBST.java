package com.dsaninja.lc.recursionI;

import com.dsaninja.lc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's
 * (binary search trees), which has exactly n nodes of unique values
 * from 1 to n. Return the answer in any order.
 *
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Problem-95</a>
 */
public class UniqueBST{
    public List<TreeNode> generate(int n){
        if(n == 0){
            return List.of();
        }
        return calc(1, n);
    }

    /**
     * Given a sorted sequence 1 ... n, to construct a Binary Search Tree (BST)
     * out of the sequence, we could enumerate each number i in the sequence,
     * and use the number as the root, then, the subsequence 1 ... (i-1) on its left
     * side would lay on the left branch of the root, and similarly the right
     * subsequence (i+1) ... n lay on the right branch of the root.
     * <p>
     * Through the above approach, we could be assured that the BST that we
     * construct are all unique, since they start from unique roots.
     *
     * @param start start of sequence
     * @param end   end of sequence
     * @return tree nodes
     */
    private List<TreeNode> calc(int start, int end){
        List<TreeNode> all = new ArrayList<>();
        if(start > end){
            all.add(null);
            return all;
        }

        // from start to end
        for(int i = start; i <= end; i++){
            // generate left and right trees
            // excluding i
            List<TreeNode> left = calc(start, i - 1);
            List<TreeNode> right = calc(i + 1, end);

            // for all left trees
            for(TreeNode l : left){
                // prepare pairs with all the right trees
                for(TreeNode r : right){
                    // add add those to individual i nodes
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    all.add(curr);
                }
            }
        }

        return all;
    }
}
