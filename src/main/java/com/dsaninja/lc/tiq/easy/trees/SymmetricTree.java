package com.dsaninja.lc.tiq.easy.trees;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
 */
public class SymmetricTree {
    // left of left should be equal to right of right
    // and right of left should be equal to left or right
    public boolean isSymmetric(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }

        return test(root.left, root.right);
    }

    private boolean test(TreeNode left, TreeNode right) {
        if(null == left && null == right){
            return true;
        }

        return (null != left && null != right) &&
                left.val == right.val &&
                test(left.left, right.right) &&
                test(left.right, right.left);
    }
}
