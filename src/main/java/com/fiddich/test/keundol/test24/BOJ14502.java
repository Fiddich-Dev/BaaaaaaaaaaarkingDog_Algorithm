package com.fiddich.test.keundol.test24;

import java.util.*;

public class BOJ14502 {

    static int n, m;
    static int[][] a;
    static List<Pair> virous = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;
    static int wallCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) {
                    virous.add(new Pair(i, j));
                }
                else if(a[i][j] == 1) {
                    wallCnt++;
                }
            }
        }

        go(0, 0, 0);
        System.out.println(ret);
    }

    static int bfs() {
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(Pair p : virous) {
            q.add(new Pair(p.y, p.x));
            visited[p.y][p.x] = 1;
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            cnt++;
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }
        }

        return n*m - cnt - wallCnt - 3;
    }

    static void go(int y, int x, int cnt) {
        if(cnt == 3) {
            ret = Math.max(ret, bfs());
            return;
        }

        if(y == n) {
            return;
        }

        int nx = x + 1;
        int ny = y;
        if(nx == m) {
            nx = 0;
            ny++;
        }

        if(a[y][x] == 0) {
            a[y][x] = 1;
            go(ny, nx, cnt + 1);
            a[y][x] = 0;
        }

        go(ny, nx, cnt);
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
