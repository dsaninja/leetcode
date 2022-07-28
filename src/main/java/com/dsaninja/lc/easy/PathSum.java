package com.dsaninja.lc.easy;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 *
 * <a href="https://leetcode.com/problems/path-sum/">Problem-112</a>
 */
public class PathSum{
    public boolean hasPathSum(TreeNode root, int targetSum){
        return solve(root, 0, targetSum);
    }

    private boolean solve(TreeNode root, int localSum, int target){
        if(null == root){
            return false;
        }

        // leaf node - add current node value to the
        // localSum and compare
        if(null == root.left && null == root.right){
            return localSum + root.val == target;
        }

        return solve(root.left, localSum + root.val, target) ||
                solve(root.right, localSum + root.val, target);
    }

    private static final class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    @Test
    public void testPathSum(){
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode elvn = new TreeNode(11);
        TreeNode two = new TreeNode(2);
        TreeNode svn = new TreeNode(7);

        root.left = four;
        four.left = elvn;
        elvn.left = svn;
        elvn.right = two;

        assertTrue(hasPathSum(root, 22));

    }
}
