package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ21736 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'I') {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            if(a[y][x] == 'P') {
                cnt++;
            }
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != 'X') {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }

        if(cnt == 0) {
            System.out.println("TT");
        }
        else {
            System.out.println(cnt);
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
