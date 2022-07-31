package com.dsaninja.lc.easy;

import com.dsaninja.lc.common.TreeNode;

/**
 * Given the root of a binary tree, invert the tree,
 * and return its root.
 *
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Problem-226</a>
 */
public class InvertTree{
    public TreeNode invertTree(TreeNode root) {
        if(null == root){
            return root;
        }

        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
