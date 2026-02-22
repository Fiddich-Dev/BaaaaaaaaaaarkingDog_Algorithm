package com.fiddich.test.keundol.test2;

import java.util.*;

public class BOJ2583 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int lx = sc.nextInt();
            int ly = n - sc.nextInt() - 1;

            int rx = sc.nextInt() - 1;
            int ry = n - sc.nextInt();

            fill(ly, lx, ry, rx);
        }

        int cnt = 0;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0 && visited[i][j] == 0) {
                    ret.add(bfs(i, j));
                    cnt++;
                }
            }
        }

        Collections.sort(ret);
        System.out.println(cnt);
        for(int i : ret) {
            System.out.print(i + " ");
        }
    }

    static int bfs(int sy, int sx) {
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pair(sy, sx));

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
        return cnt;
    }

    static void fill(int ly, int lx, int ry, int rx) {
        for(int i = ry; i <= ly; i++) {
            for(int j = lx; j <= rx; j++) {
                a[i][j] = 1;
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
