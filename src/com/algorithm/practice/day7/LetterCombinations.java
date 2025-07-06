package com.algorithm.practice.day7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
public class LetterCombinations {

    private static List<String> res = new ArrayList<>();
    private static Map<Character, String> map = new HashMap<>();
    static{
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        search(digits, 0, "");

        return res;
    }

    private static void search(String digits, int index, String s){
        if (index == digits.length()){
            // search finish
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = map.get(c);
        for (int i = 0; i < letters.length(); i++) {
            search(digits, index + 1, s + letters.charAt(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations(""));

    }
}
