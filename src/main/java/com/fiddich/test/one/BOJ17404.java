package com.fiddich.test.one;

import java.util.*;

public class BOJ17404 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][][] dp = new int[3][n+1][3];

        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }


        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) {
                    dp[i][1][j] = a[0][j];
                }
                else {
                    dp[i][1][j] = 987654321;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 2; j <= n; j++) {
                for(int k = 0; k < 3; k++) {
                    dp[i][j][k] = Math.min(dp[i][j-1][(k+1) % 3], dp[i][j-1][(k+2) % 3]) + a[j-1][k];
                }
            }
        }



        List<Integer> ret = new ArrayList<>();
        ret.add(dp[0][n][1]);
        ret.add(dp[0][n][2]);
        ret.add(dp[1][n][0]);
        ret.add(dp[1][n][2]);
        ret.add(dp[2][n][0]);
        ret.add(dp[2][n][1]);

        Collections.sort(ret);
        System.out.println(ret.get(0));
    }
}
// dp[a][b][c] 첫번쨰 집은 c로 칠했을때 a번쨰를 b로 칠했을 때의 최솟값