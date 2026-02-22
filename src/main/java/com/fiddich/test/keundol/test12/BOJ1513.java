package com.fiddich.test.keundol.test12;

import java.util.*;

public class BOJ1513 {

    static int n, m, c;
    static int[][] a;
    static int[][][][] dp = new int[54][54][54][54];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        a = new int[n+1][m+1];



        for(int i = 0; i < c; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            a[y][x] = i+1;
        }

        if(a[1][1] == 0) {
            dp[1][1][0][0] = 1;
        }
        else {
            dp[1][1][1][a[1][1]] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int cur = a[i][j];

                // 오락실이 있을때
                if(cur != 0) {
                    for(int k = 0; k <= c; k++) { // 다음 항은 k+1
                        for(int l = 0; l < cur; l++) { // cur 보다 작아야함
                            dp[i][j][k+1][cur] += dp[i-1][j][k][l];
                            dp[i][j][k+1][cur] %= 1000007;
                            dp[i][j][k+1][cur] += dp[i][j-1][k][l];
                            dp[i][j][k+1][cur] %= 1000007;
                        }
                    }
                }
                // 오락실이 없을때
                else {
                    for(int k = 0; k <= c; k++) { // 다음 항은 k+1
                        for(int l = 0; l <= c; l++) { // cur 보다 작아야함
                            dp[i][j][k][l] += dp[i-1][j][k][l];
                            dp[i][j][k][l] %= 1000007;
                            dp[i][j][k][l] += dp[i][j-1][k][l];
                            dp[i][j][k][l] %= 1000007;
                        }
                    }
                }
            }
        }

        for(int i = 0; i <= c; i++) {
            System.out.print(calc(i) + " ");
        }
    }

    static int calc(int num) {
        int sum = 0;
        for(int i = 0; i <= c; i++) {
            sum += dp[n][m][num][i];
        }
        return sum % 1000007;
    }
}

//dp[i][j][a][b] = (i, j)를 a개의 오락실을 거치고 마지막으로 b의 오락실을 거쳐가는 경우의 수
