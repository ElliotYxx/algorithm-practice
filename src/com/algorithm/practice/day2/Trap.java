package com.algorithm.practice.day2;

/**
 * @Author: Elliot
 * @Date: 2025-06-26 16:11
 * @Description: todo
 *
 * //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * //
 * //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * //输出：6
 * //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：height = [4,2,0,3,2,5]
 * //输出：9
 **/
public class Trap {


    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }

    public static int trap(int[] height) {

        if (height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] pre = new int[len];
        pre[0] = height[0];
        int[] suf = new int[len];
        suf[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }
        for (int i = len - 2; i > 0; i--) {
            suf[i] = Math.max(suf[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int curr = Math.min(suf[i], pre[i]) - height[i];
            if (curr > 0){
                res += curr;
            }
        }

        return res;
    }
}
