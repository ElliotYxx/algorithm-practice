package com.algorithm.practice.day7;


import com.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [2,1,3]
//输出: 1
//
//
// 示例 2:
//
//
//
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
public class FindBottomLeftValue {


    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}
