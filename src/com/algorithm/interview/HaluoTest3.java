package com.algorithm.interview;

import java.util.Arrays;

/**
 * @Author: Elliot
 * @Date: 2025-07-02 19:15
 * @Description: todo
 *
 *
 * 假设存在一只股票，给过去一段时间的价格，找到最佳的买入时间和卖出时间，使得买卖一次就能获得最高收益
 *
 *
 **/
public class HaluoTest3 {





    public static void main(String[] args) {


        // case1 [0,1]
        System.out.println(Arrays.toString(saleProfit(new int[]{3, 4, 3, 2, 1})));
        // case1 [0,1]
        System.out.println(Arrays.toString(saleProfit(new int[]{1, 4, 3, 2, 1})));
        // case2 []
        System.out.println(Arrays.toString(saleProfit(new int[]{4, 3, 2, 1})));
        // case 3 [0,3]
        System.out.println(Arrays.toString(saleProfit(new int[]{5,8,9,11})));
        // case 4 [2,3]
        System.out.println(Arrays.toString(saleProfit(new int[]{11,9,4,8})));
        // case 5 []
        System.out.println(Arrays.toString(saleProfit(new int[]{11,11,11,11})));
        // case 6 [1,2]
        System.out.println(Arrays.toString(saleProfit(new int[]{11,1,18,18})));
        // case 7 [2,4]
        System.out.println(Arrays.toString(saleProfit(new int[]{10, 4, 1, 8, 11})));





    }


    /**
     * 假设存在一只股票，给过去一段时间的价格，找到最佳的买入时间和卖出时间，使得买卖一次就能获得最高收益
     * 输入：[1,4,3,2,1]
     * 输出：3
     *
     */
    public static int[] saleProfit(int[] prices){

        if (prices == null || prices.length == 0){
            return new int[]{};
        }

//        int minPrice = prices[0];
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int buyIn = 0;
        int saleOut = 0;
        int currMinIndex = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
                currMinIndex = i;
            }
            int currProfit = prices[i] - minPrice;
            if (currProfit > profit){
                profit = currProfit;
                buyIn = currMinIndex;
                saleOut = i;
            }

        }

        if (profit == 0){
            return new int[]{};
        }else{
            return new int[]{buyIn, saleOut};
        }

    }
}
