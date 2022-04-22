package com.dsaninja.lc.tiq.easy.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 *
 * <ol>
 *      <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 *      <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 *      <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ol>
 * <p>
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">Problem-98</a>
 */
public class ValidBST{

    // The problem is this approach will not work for all cases. Not only the right child should be
    // larger than the node but all the elements in the right subtree.
    // That means one should keep both upper and lower limits for each node while traversing the tree,
    // and compare the node value not with children values but with these limits.
    public boolean bstHelper(TreeNode root, Integer low, Integer max){
        if(null == root){
            return true;
        }

        if((null != low && root.val <= low) || (null != max && root.val >= max)){
            return false;
        }
        return bstHelper(root.left, low, root.val) && bstHelper(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root){
        return bstHelper(root, null, null);
    }

    @Test
    public void testValidBST(){
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);

        root.left = four;
        root.right = six;
        six.left = three;
        six.right = seven;

        assertFalse(isValidBST(root));
    }
}
