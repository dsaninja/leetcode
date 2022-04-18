package com.dsaninja.lc.tiq.easy.trees;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes'
 * values. (i.e., from left to right, level by level).
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
 */
public class BSTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode polled = queue.poll();
                subList.add(polled.val);

                if (null != polled.left) {
                    queue.add(polled.left);
                }

                if (null != polled.right) {
                    queue.add(polled.right);
                }
            }
            result.add(subList);
        }

        return result;
    }

    @Test
    public void testLevelOrderTraversal() {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        List<List<Integer>> lists = levelOrder(root);
        assertEquals(3, lists.size());
        assertEquals(3, lists.get(0).get(0));
        assertEquals(9, lists.get(1).get(0));
        assertEquals(20, lists.get(1).get(1));
        assertEquals(15, lists.get(2).get(0));
        assertEquals(7, lists.get(2).get(1));
    }
}
