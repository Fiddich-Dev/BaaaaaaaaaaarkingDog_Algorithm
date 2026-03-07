package com.fiddich.bfs;

import java.util.*;

public class BOJ2206 {

    static int n, m;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][][] visited = new int[n][m][2];
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()) {
            Info info = q.poll();
            int y = info.y;
            int x = info.x;
            int cnt = info.cnt;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 0 && visited[ny][nx][cnt] == 0) {
                    visited[ny][nx][cnt] = visited[y][x][cnt] + 1;
                    q.add(new Info(ny, nx, cnt));
                }

                if(cnt == 0 && a[ny][nx] == 1 && visited[ny][nx][1] == 0) {
                    visited[ny][nx][cnt+1] = visited[y][x][cnt] + 1;
                    q.add(new Info(ny, nx, cnt+1));
                }
            }
        }

        if(visited[n-1][m-1][0] == 0 && visited[n-1][m-1][1] == 0) {
            System.out.println(-1);
            return;
        }
        if(visited[n-1][m-1][0] == 0) {
            System.out.println(visited[n-1][m-1][1]);
            return;
        }
        if(visited[n-1][m-1][1] == 0) {
            System.out.println(visited[n-1][m-1][0]);
            return;
        }
        System.out.println(Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]));
    }

    static class Info {
        int y;
        int x;
        int cnt;

        public Info(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
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
