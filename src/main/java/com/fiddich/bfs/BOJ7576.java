package com.fiddich.bfs;

import java.util.*;

public class BOJ7576 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];

        int yes = 0;
        int no = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                    yes++;
                }
                if(a[i][j] == 0) {
                    no++;
                }
            }
        }



        if(no == 0) {
            System.out.println(0);
            return;
        }

        int ret = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            Pair now = q.poll();
            cnt++;
            int y = now.y;
            int x = now.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                    ret = Math.max(ret, visited[ny][nx]);
                }
            }
        }

        if(cnt < yes + no) {
            System.out.println(-1);
            return;
        }

        System.out.println(ret - 1);
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
