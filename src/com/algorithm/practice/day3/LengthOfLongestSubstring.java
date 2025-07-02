package com.algorithm.practice.day3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Elliot
 * @Date: 2025-06-30 21:30
 * @Description: todo
 *
 * //给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: s = "abcabcbb"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: s = "bbbbb"
 * //输出: 1
 * //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * //
 * // 示例 3:
 * //
 * //
 * //输入: s = "pwwkew"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 **/
public class LengthOfLongestSubstring {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int ans = 0;
        Set<Character> charSet = new HashSet<>();
        while(r < s.length()){
            char currChar = s.charAt(r);
            while (charSet.contains(currChar)){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(currChar);
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
