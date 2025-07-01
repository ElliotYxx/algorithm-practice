package practice.day4;

import java.util.Arrays;

/**
 * @Author: Elliot
 * @Date: 2025-06-30 21:46
 * @Description: todo
 * //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * //
 * // 如果数组中不存在目标值 target，返回 [-1, -1]。
 * //
 * // 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [5,7,7,8,8,10], target = 8
 * //输出：[3,4]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [5,7,7,8,8,10], target = 6
 * //输出：[-1,-1]
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [], target = 0
 * //输出：[-1,-1]
 **/
public class SearchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 6)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);

        return new int[]{start, end};
    }

    private static int findEnd(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int end = -1;

        // [l,r]
        while(l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                end = mid;
                l = mid + 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return end;
    }

    private static int findStart(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int start = -1;

        // [l,r]
        while(l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                start = mid;
                r = mid - 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return start;
    }


}
