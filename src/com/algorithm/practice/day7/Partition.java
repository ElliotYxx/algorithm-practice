package com.algorithm.practice.day7;


import java.util.ArrayList;
import java.util.List;

//给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
public class Partition {


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, String s, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current)); // 添加当前分割方案到结果中
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                current.add(substring); // 选择一个回文子串
                backtrack(end, s, current, result); // 递归处理下一个子串
                current.remove(current.size() - 1); // 回溯，撤销选择
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition solution = new Partition();
        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("a"));
    }
}
