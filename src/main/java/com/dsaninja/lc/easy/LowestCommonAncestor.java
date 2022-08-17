package com.dsaninja.lc.easy;

import com.dsaninja.lc.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary search tree (BST), find the lowest common
 * ancestor (LCA) node of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest
 * common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we
 * allow a node to be a descendant of itself).”
 *
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Problem-235</a>
 */
public class LowestCommonAncestor{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    @Test
    public void testLCA(){
        assertEquals(6, lowestCommonAncestor(TreeNode.populate(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), new TreeNode(2),
                new TreeNode(8)).val);
    }

}
