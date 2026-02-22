package com.fiddich.test.keundol.test1;

import java.util.*;

public class BOJ1012 {

    static int m, n;
    static int[][] visited;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            a = new int[n][m];
            visited = new int[n][m];
            int k = sc.nextInt();
            for(int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y =sc.nextInt();
                a[y][x] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == 0 && a[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int sy, int sx) {
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
                if(visited[ny][nx] == 0 && a[ny][nx] == 1) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
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
