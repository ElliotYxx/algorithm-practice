package com.algorithm;

/**
 * @Author: Elliot
 * @Date: 2025-07-02 15:39
 * @Description: todo
 **/
public class TreeNode {

    public Integer val;

    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}

    public TreeNode(Integer val) {
        this.val = val;
    }
    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
