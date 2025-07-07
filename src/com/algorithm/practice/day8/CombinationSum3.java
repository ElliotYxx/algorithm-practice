package com.algorithm.practice.day8;


import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//
// 只使用数字1到9
// 每个数字 最多使用一次
//
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//
//
//
// 示例 1:
//
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。
//
// 示例 2:
//
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。
//
// 示例 3:
//
//
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
//
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int k, int n, int start) {
        // 如果路径长度等于k且当前和为0，说明找到了一个有效组合
        if (path.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 遍历从start到9的所有数字
        for (int i = start; i <= 9; i++) {
            // 如果当前数字大于剩余目标值，直接跳过
            if (i > n) {
                break;
            }
            // 将当前数字加入路径
            path.add(i);
            // 递归调用，更新目标值为n-i，起始值为i+1
            backtrack(result, path, k, n - i, i + 1);
            // 回溯，移除最后一个数字
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();
        // case1
        System.out.println(solution.combinationSum3(3, 9));


    }
}
