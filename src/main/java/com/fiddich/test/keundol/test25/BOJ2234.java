package com.fiddich.test.keundol.test25;

import java.util.*;

public class BOJ2234 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int[] compSize;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        compSize = new int[n*m+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret1 = 0;
        int ret2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0) {
                    ret1++;
                    int cnt = bfs(i, j, ret1);
                    ret2 = Math.max(ret2, cnt);
                    compSize[ret1] = cnt;
                }
            }
        }

        System.out.println(ret1);
        System.out.println(ret2);

        int ret3 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(visited[i][j] != visited[ny][nx]) {
                        ret3 = Math.max(ret3, compSize[visited[i][j]] + compSize[visited[ny][nx]]);
                    }
                }
            }
        }

        System.out.println(ret3);
    }

    static int bfs(int sy, int sx, int num) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx));
        visited[sy][sx] = num;

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
                if(visited[ny][nx] == 0 && (a[y][x] & (1 << i)) == 0) {
                    visited[ny][nx] = num;
                    q.add(new Pair(ny, nx));
                }
            }
        }
        return cnt;
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
