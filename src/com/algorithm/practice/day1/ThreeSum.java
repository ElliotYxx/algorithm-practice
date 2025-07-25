package com.algorithm.practice.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Elliot
 * @Date: 2025-06-25 20:12
 * @Description: todo
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 **/
public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));



    }

    /**
     * 时间复杂度 O(nlogn+n^2)
     * 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 判空
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // 两数之河2变种，先将数据排序，最后要找的target=-nums[i]
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(l > r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }

            }

        }

        return result;
    }
}
