package com.fiddich.test.keundol.test26;

import java.util.*;

public class BOJ2342 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] dp = new int[100004][5][5];
        int[][] cost = new int[5][5];
        makeCost(cost);

        for(int i = 0; i < 100004; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    dp[i][j][k] = 987654321;
                }
            }
        }
        dp[0][0][0] = 0;

        int ret = Integer.MAX_VALUE;
        int idx = 0;
        while(true) {
            idx++;
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }

            for(int i = 0; i < 5; i++) { // 안움직일 발의 위치
                if(n == i) {
                    continue;
                }

                for(int j = 0; j < 5; j++) { // 움직일 발의 이전 위치
                    dp[idx][n][i] = Math.min(dp[idx][n][i], dp[idx-1][j][i] + cost[j][n]);
                    dp[idx][i][n] = Math.min(dp[idx][i][n], dp[idx-1][i][j] + cost[j][n]);
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                ret = Math.min(ret, dp[idx-1][i][j]);
            }
        }
        System.out.println(ret);
    }

    static void makeCost(int[][] cost) {
        cost[0][1] = 2;
        cost[0][2] = 2;
        cost[0][3] = 2;
        cost[0][4] = 2;

        cost[1][1] = 1;
        cost[1][2] = 3;
        cost[1][3] = 4;
        cost[1][4] = 3;

        cost[2][1] = 3;
        cost[2][2] = 1;
        cost[2][3] = 3;
        cost[2][4] = 4;

        cost[3][1] = 4;
        cost[3][2] = 3;
        cost[3][3] = 1;
        cost[3][4] = 3;

        cost[4][1] = 3;
        cost[4][2] = 4;
        cost[4][3] = 3;
        cost[4][4] = 1;
    }
}
// dp[n][m][k] = n번째까지 고려했을떄 왼발은 m 오른발은 k에 있을때의 드는 힘

