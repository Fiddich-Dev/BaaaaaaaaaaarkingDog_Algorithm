package com.fiddich.test.keundol.test20;

import java.util.*;

public class BOJ1987 {

    static int r, c;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        a = new int[r][c];
        for(int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j) - 'A';
            }
        }

        int[] visited = new int[26];
        visited[a[0][0]] = 1;
        dfs(0, 0, visited, 1);

        System.out.println(ret);
    }

    static void dfs(int sy, int sx, int[] visited, int depth) {

        ret = Math.max(ret, depth);

        for(int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                continue;
            }
            if(visited[a[ny][nx]] == 0) {
                visited[a[ny][nx]] = 1;
                dfs(ny, nx, visited, depth+1);
                visited[a[ny][nx]] = 0;
            }
        }
    }
}
