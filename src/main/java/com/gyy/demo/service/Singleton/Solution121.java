package com.gyy.demo.service.Singleton;

public class Solution121 {

    /**
     * 超出时间限制
     */
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = prices[j] - prices[i];
                if (a > max) {
                    max = a;
                }

            }
        }
        return max;

    }


    /**
     * 正确答案
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < len; i++) {
            minPrice = Math.min(prices[i],minPrice);
            maxprofit = Math.max(maxprofit,prices[i] -minPrice);
        }
        return  maxprofit;
        }

}
