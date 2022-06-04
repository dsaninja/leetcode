package com.dsaninja.lc.recursion1;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 *
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">Problem-700</a>
 */
public class SearchBST{
    public TreeNode searchBST(TreeNode root, int val){
        if(null == root || val == root.val){
            return root;
        }

        if(val < root.val){
            return searchBST(root.left, val);
        } else{
            return searchBST(root.right, val);
        }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
