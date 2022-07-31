package com.dsaninja.lc.dailychallenge;

import com.dsaninja.lc.common.TreeNode;

/**
 * You are given the root of a binary tree. We install cameras on
 * the tree nodes where each camera at a node can monitor its parent, itself, and
 * its immediate children.
 *
 * <p>
 * Return the minimum number of cameras needed to monitor all
 * nodes of the tree.
 * <p>
 * <img src="https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_01.png" style="margin-right: 5px;"/>
 * <img src="https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_02.png" style="margin-left: 5px;"/>
 * </p>
 * <pre>
 *     Input: root = [0,0,null,0,0]
 *     Output: 1
 *     Explanation: One camera is enough to monitor all nodes if placed as shown.
 * </pre>
 *
 * <a href="https://leetcode.com/problems/binary-tree-cameras/discuss/2160360/Visual-Explanation-or-JAVA-Greedy">Discussion</a>
 * <a href="https://leetcode.com/problems/binary-tree-cameras/">Problem-968</a>
 */
public class BinaryTreeCameras{
    int cameras = 0;

    public int minCameraCover(TreeNode root){
        return dfs(root) == -1 ? cameras + 1 : cameras;
    }

    // -1 : not monitored
    // 0 : monitored
    // 1 : has camera
    // TC: O(n); SC: O(h) -> h is height
    private int dfs(TreeNode root){
        if(null == root){
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        // if either of the children is not
        // monitored; place a camera here
        if(l == -1 || r == -1){
            cameras++;
            return 1;
        }

        // if either of the children has camera
        // return 0 to denote that current node is monitored
        if(l == 1 || r == 1){
            return 0;
        }

        return -1;
    }
}
