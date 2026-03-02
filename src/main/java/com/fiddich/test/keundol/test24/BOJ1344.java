package com.fiddich.test.keundol.test24;

import java.util.*;

public class BOJ1344 {

    static int a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        double perA = (double) a / 100;
        double perB = (double) b / 100;

        double[][][] dp = new double[20][20][20];

        dp[0][0][0] = 1;

        for(int i = 1; i <= 18; i++) {
            for(int j = 0; j <= i; j++) {
                for(int k = 0; k <= i; k++) {
                    dp[i][j][k] += dp[i-1][j][k] * (1 - perA) * (1 - perB);
                    if(j > 0) {
                        dp[i][j][k] += dp[i - 1][j - 1][k] * perA * (1 - perB);
                    }
                    if(k > 0) {
                        dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - perA) * perB;
                    }
                    if(j > 0 && k > 0) {
                        dp[i][j][k] += dp[i-1][j-1][k-1] * perA * perB;
                    }
                }
            }
        }

        double ret = 0;
        int[] temp = {2, 3, 5, 7, 11, 13, 17};
        for(int i : temp) {
            for(int j = 0; j <= 18; j++) {
                ret += dp[18][i][j];
                ret += dp[18][j][i];
            }
        }

        for(int i : temp) {
            for(int j : temp) {
                ret -= dp[18][i][j];
            }
        }

        System.out.println(ret);
    }
}
