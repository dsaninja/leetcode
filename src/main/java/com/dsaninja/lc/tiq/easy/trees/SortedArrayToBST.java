package com.dsaninja.lc.tiq.easy.trees;

import com.dsaninja.lc.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums where the elements are sorted in
 * ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth
 * of the two subtrees of every node never differs by more than one.
 * <p>
 *
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Problem-108</a>
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid - 1);
        root.right = create(nums, mid + 1, end);

        return root;
    }

    @Test
    public void testSortedArrayToBST() {
        TreeNode bst = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertEquals(0, bst.val);
        assertEquals(-10, bst.left.val);
        assertEquals(5, bst.right.val);
    }
}
