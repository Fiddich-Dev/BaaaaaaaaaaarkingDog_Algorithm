package com.fiddich.test.keundol.test25;

import java.util.*;

public class BOJ1189 {

    static int r, c, k;
    static char[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        a = new char[r][c];
        visited = new int[r][c];
        for(int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        visited[r-1][0] = 1;
        dfs(r-1, 0, 1);

        System.out.println(cnt);
    }

    static void dfs(int y, int x, int depth) {
        if(y == 0 && x == c-1) {
            if(depth == k) {
                cnt++;
            }
            return;
        }

        if(depth == k) {
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] != 'T') {
                visited[ny][nx] = 1;
                dfs(ny, nx, depth + 1);
                visited[ny][nx] = 0;
            }
        }
    }
}
