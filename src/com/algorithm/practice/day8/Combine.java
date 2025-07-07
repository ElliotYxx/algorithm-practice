package com.algorithm.practice.day8;

import java.util.ArrayList;
import java.util.List;


//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
public class Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        search(result, new ArrayList<>(), 1, n, k);
        return result;
    }


    private void search(List<List<Integer>> result, List<Integer> current, int start, int n, int k){

        if (current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            search(result, current, i + 1, n, k);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine solution = new Combine();
        // case1
        System.out.println(solution.combine(4, 2));
        // case2
        System.out.println(solution.combine(1, 1));
    }
}
