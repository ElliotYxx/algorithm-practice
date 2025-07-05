package com.algorithm.practice.day6;


import com.algorithm.TreeNode;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {



        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode a, TreeNode b){
        if (a == null && b == null){
            return true;
        }
        if (a == null || b == null){
            return false;
        }

        return a.val == b.val && isSymmetric(a.left, b.right) &&  isSymmetric(a.right, b.left);
    }
}
