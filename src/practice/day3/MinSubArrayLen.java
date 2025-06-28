package practice.day3;

/**
 * @Author: Elliot
 * @Date: 2025-06-27 22:40
 * @Description: todo
 *
 * //给定一个含有 n 个正整数的数组和一个正整数 target 。
 * //
 * // 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
 * //长度。如果不存在符合条件的子数组，返回 0 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：target = 7, nums = [2,3,1,2,4,3]
 * //输出：2
 * //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：target = 4, nums = [1,4,4]
 * //输出：1
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * //输出：0
 **/
public class MinSubArrayLen {


    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

    }


    public static int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int l = 0;
        int ans = len + 1;
        int sum = 0;

        // 滑动窗口 不断向右扩展
        for (int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum >= target){
                ans = Math.min(r - l + 1, ans);
                sum -= nums[l];
                l++;
            }
        }

        return ans == len + 1 ? 0 : ans;
    }



}
