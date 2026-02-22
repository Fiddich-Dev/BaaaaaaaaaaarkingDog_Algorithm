package com.fiddich.test.keundol.test3;

import java.util.*;

public class BOJ1103 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;
    static boolean flag = false;
    static int[][] dp;
    static boolean isRotate = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        dp = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == 'H') {
                    a[i][j] = -1;
                    continue;
                }
                a[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        if(isRotate) {
            System.out.println(-1);
            return;
        }

//        int result = Integer.MIN_VALUE;
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                result = Math.max(result, dp[i][j]);
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[0][0]);
    }

    static int dfs(int sy, int sx) {

        if(dp[sy][sx] != 0) {
            return dp[sy][sx];
        }

        int num = a[sy][sx];
        int currentMax = 1;

        for(int i = 0; i < 4; i++) {
            int ny = sy + dy[i] * num;
            int nx = sx + dx[i] * num;

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == -1) {
                continue;
            }

            if(visited[ny][nx] == 1) {
                isRotate = true;
                return -1;
            }
            visited[ny][nx] = 1;
            currentMax = Math.max(currentMax, dfs(ny, nx) + 1);
            visited[ny][nx] = 0;
        }

        return dp[sy][sx] = currentMax;
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
