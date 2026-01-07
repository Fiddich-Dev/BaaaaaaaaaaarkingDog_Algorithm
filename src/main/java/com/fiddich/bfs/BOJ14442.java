package com.fiddich.bfs;

import java.util.*;

public class BOJ14442 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m];
        int[][][] visited = new int[n][m][k+1];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pos> q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.add(new Pos(0, 0, 0));

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int y = p.y;
            int x = p.x;
            int cnt = p.cnt;

            // 벽울 안부술떄
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 0 && visited[ny][nx][cnt] == 0) {
                    visited[ny][nx][cnt] = visited[y][x][cnt] + 1;
                    q.add(new Pos(ny, nx, cnt));
                }

                if(cnt == k) {
                    continue;
                }

                if(a[ny][nx] == 1 && visited[ny][nx][cnt+1] == 0) {
                    visited[ny][nx][cnt+1] = visited[y][x][cnt] + 1;
                    q.add(new Pos(ny, nx, cnt+1));
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int i = 0; i <= k; i++) {
            if(visited[n-1][m-1][i] == 0) {
                continue;
            }
            ret = Math.min(ret, visited[n-1][m-1][i]);
        }

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }

    }

    static class Pos {
        int y;
        int x;
        int cnt;

        public Pos(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
