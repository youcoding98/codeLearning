package com.bupt.jianzhioffer;

/**
 * Offer019:正则表达式匹配
 * @author Administrator
 */
public class Offer019 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则
                if (j == 0){
                    f[i][j] = i == 0;
                }else {
                    //非空正则分成两种*和非*
                    if (p.charAt(j - 1) != '*'){
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else {
                        //碰到*了，分为看和不看
                        if (j >= 2){
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
