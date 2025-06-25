package practice.day1;

import java.util.Arrays;

/**
 * @Author: Elliot
 * @Date: 2025-06-25 22:25
 * @Description: todo
 *
 *
 * //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * //
 * // 返回这三个数的和。
 * //
 * // 假定每组输入只存在恰好一个解。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [-1,2,1,-4], target = 1
 * //输出：2
 * //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,0,0], target = 1
 * //输出：0
 * //解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 **/
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(min - target)){
                    min = sum;
                }
                if (sum > target){
                    r--;
                }else if (sum < target){
                    l++;
                }else{
                    return sum;
                }
            }
        }

        return min;
    }
}
