package com.fiddich.test.keundol.test15;

import java.util.*;

public class BOJ14497 {

    static int n, m;
    static Pair j = new Pair(0, 0);
    static Pair b = new Pair(0, 0);
    static char[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        j.y = sc.nextInt() - 1;
        j.x = sc.nextInt() - 1;
        b.y = sc.nextInt() - 1;
        b.x = sc.nextInt() - 1;
        a = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        a[b.y][b.x] = '1';

        int ret = 0;
        while(true) {
            ret++;
            visited = new int[n][m];
            bfs(j.y, j.x);
            if(a[b.y][b.x] == '0') {
                break;
            }
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
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0) {
                    if(a[ny][nx] == '0') {
                        visited[ny][nx] = visited[y][x] + 1;
                        q.add(new Pair(ny, nx));
                    }
                    else {
                        visited[ny][nx] = visited[y][x] + 1;
                        a[ny][nx] = '0';
                    }
                }
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
