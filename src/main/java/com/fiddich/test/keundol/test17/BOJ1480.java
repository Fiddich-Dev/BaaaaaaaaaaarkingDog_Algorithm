package com.fiddich.test.keundol.test17;

import java.util.*;

public class BOJ1480 {

    static int n, m, c;
    static int[] a;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        dp = new int[m][c + 1][1 << n];
        for(int[][] i : dp) {
            for(int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        System.out.println(go(0, c, 0));
    }

    static int go(int bagIdx, int curSpace, int status) {
        if(bagIdx == m || status == (1 << n) - 1) {
            return 0;
        }

        if(dp[bagIdx][curSpace][status] != -1) {
            return dp[bagIdx][curSpace][status];
        }

        // 현재 가방에 더이상 안담고 다음 가방으로 넘기기
        int ret = go(bagIdx + 1, c, status);

        for(int i = 0; i < n; i++) {
            if((status & (1 << i)) == 0 && curSpace >= a[i]) {
                ret = Math.max(ret, go(bagIdx, curSpace - a[i], status | (1 << i)) + 1);
            }
        }

        return dp[bagIdx][curSpace][status] = ret;
    }
}
// dp[i][j][k] = 현재 가방의 여유공간이 i, 사용할 수 있는 여유 가방의 개수가 j, 보석의 상태가 k일 때 훔칠 수 있는 보석의 최대 개수