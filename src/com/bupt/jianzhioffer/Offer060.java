package com.bupt.jianzhioffer;

/**
 * Offer060:n个骰子的点数
 * @author Administrator
 */
public class Offer060 {
    public double[] dicesProbability(int n) {
        double[] dp = {1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            //n-1个骰子
            for (int j = 0; j < dp.length; j++) {
                //一个骰子
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] * (1/6d);
                }
            }
            dp = temp;
        }
        return dp;
    }
}
