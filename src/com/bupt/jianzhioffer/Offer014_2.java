package com.bupt.jianzhioffer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Offer14_2:剪绳子II
 * @author Administrator
 */
public class Offer014_2 {
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(3);
        for (int i = 4; i <= n; i++) {
            if (dp[i-2].multiply(BigInteger.valueOf(2)).compareTo(dp[i-3].multiply(BigInteger.valueOf(3))) > 0){
                dp[i] = dp[i-2].multiply(BigInteger.valueOf(2));
            }else{
                dp[i] = dp[i-3].multiply(BigInteger.valueOf(3));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
