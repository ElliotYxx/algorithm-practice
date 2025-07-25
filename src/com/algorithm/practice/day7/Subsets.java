package com.algorithm.practice.day7;


import java.util.ArrayList;
import java.util.List;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
public class Subsets {


    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        search(0, nums, new ArrayList<>(), result);
        return result;

    }

    private static void search(int start, int[] nums, List<Integer> current, List<List<Integer>> resultList){
        resultList.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            search(i + 1, nums, current, resultList);
            current.removeLast();
        }
    }


    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets(new int[]{0}));
        System.out.println(subsets(new int[]{}));
    }
}
