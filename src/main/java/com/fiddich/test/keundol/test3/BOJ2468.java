package com.fiddich.test.keundol.test3;

import java.util.*;

public class BOJ2468 {

    static int n;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                max = Math.max(max, a[i][j]);
            }
        }

        while(max-- != 0) {
            visited = new int[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(a[i][j] != 0 && visited[i][j] == 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            ret = Math.max(ret, cnt);

            rain();
        }

        System.out.println(ret);
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
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != 0) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
    }

    static void rain() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = Math.max(a[i][j] - 1, 0);
            }
        }
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
