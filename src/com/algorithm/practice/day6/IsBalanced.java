package com.algorithm.practice.day6;

import com.algorithm.TreeNode;

//给定一个二叉树，判断它是否是 平衡二叉树
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    private int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;

    }


}
