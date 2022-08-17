package com.dsaninja.lc.common;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Common class used in examples
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5
    public static TreeNode populate(Integer [] vals){
        if(vals.length == 0){
            return null;
        }

        Queue<TreeNode> levelOrder = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(vals[index++]);
        levelOrder.add(root);


        while(index < vals.length){
            if(vals[index] == null){
                index++;
                continue;
            }

            TreeNode node = levelOrder.poll();
            TreeNode left = new TreeNode(vals[index++]);
            node.left = left;
            levelOrder.add(left);

            if(index < vals.length){
                TreeNode right = new TreeNode(vals[index++]);
                node.right = right;
                levelOrder.add(right);
            }
        }

        return root;
    }
}
