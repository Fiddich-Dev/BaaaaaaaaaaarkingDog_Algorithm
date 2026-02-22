package com.fiddich.bfs;

import java.util.*;

public class BOJ1926 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        int cnt = 0;
        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && a[i][j] == 1) {
                    cnt++;
                    ret = Math.max(ret, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(ret);
    }

    static int bfs(int sy, int sx) {
        int ret = 0;
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pair(sy, sx));

        while(!q.isEmpty()) {
            Pair now = q.poll();
            ret++;
            int y = now.y;
            int x = now.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] == 1) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
        return ret;
    }

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
