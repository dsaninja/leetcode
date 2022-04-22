package com.dsaninja.lc.tiq.easy.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 * <p>
 *
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Problem-104</a>
 */
public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void testMaxDepth() {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        assertEquals(3, maxDepth(root));
    }
}
