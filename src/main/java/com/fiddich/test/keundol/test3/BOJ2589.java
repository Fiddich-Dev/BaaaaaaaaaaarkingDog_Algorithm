package com.fiddich.test.keundol.test3;

import java.util.*;

public class BOJ2589 {

    static int n, m;
    static char[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 'L') {
                    visited = new int[n][m];
                    int max = bfs(i, j) - 1;
                    ret = Math.max(ret, max);
                }
            }
        }

        System.out.println(ret);
    }

    static int bfs(int sy, int sx) {
        int ret = 1;
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pair(sy, sx));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] == 0 && a[ny][nx] == 'L') {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                    ret = Math.max(ret, visited[ny][nx]);
                }
            }
        }
        return ret;
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
