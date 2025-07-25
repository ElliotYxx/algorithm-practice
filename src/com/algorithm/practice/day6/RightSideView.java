package com.algorithm.practice.day6;

import com.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,3,null,5,null,4]
//
//
// 输出：[1,3,4]
//
// 解释：
//
//
//
// 示例 2：
//
//
// 输入：root = [1,2,3,4,null,null,null,5]
//
//
// 输出：[1,3,4,5]
//
// 解释：
//
//
//
// 示例 3：
//
//
// 输入：root = [1,null,3]
//
//
// 输出：[1,3]
//
// 示例 4：
//
//
// 输入：root = []
//
//
// 输出：[]
public class RightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (i == level - 1){
                    result.add(node.val);
                }
                // 将下一层的节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;

    }
}
