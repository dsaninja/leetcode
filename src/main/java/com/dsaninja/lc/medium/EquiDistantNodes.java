package com.dsaninja.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the
 * target node.
 *
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">Problem-863</a>
 */
public class EquiDistantNodes {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        populateParents(root, parents, null);
        bfs(target, parents, result, k);

        return result;
    }

    private void bfs(TreeNode node, Map<TreeNode, TreeNode> parents, List<Integer> result, int k){
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode ithNode = queue.remove();
                // so that we don't add a visited parent again from
                // a child node
                visited.add(ithNode);

                if(level == k){
                    result.add(ithNode.val);
                }

                if(null != ithNode.left && !visited.contains(ithNode.left)){
                    queue.add(ithNode.left);
                }

                if(null != ithNode.right && !visited.contains(ithNode.right)){
                    queue.add(ithNode.right);
                }

                if(parents.containsKey(ithNode) && !visited.contains(parents.get(ithNode))){
                    queue.add(parents.get(ithNode));
                }
            }
            level++;
        }

    }


    private void populateParents(TreeNode node, Map<TreeNode, TreeNode> parents, TreeNode parent){
        if(null != parent){
            parents.put(node, parent);
        }

        if(null != node.left){
            populateParents(node.left, parents, node);
        }

        if(null != node.right){
            populateParents(node.right, parents, node);
        }
    }


    private record TreeNode(int val, TreeNode left, TreeNode right) {
    }
}
