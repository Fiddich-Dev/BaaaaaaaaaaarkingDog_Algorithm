package com.fiddich.bfs;

import java.util.*;

public class BOJ4179 {

    static int r, c;
    static char[][] a;
    static int[][] visitedJ;
    static Queue<Pair> qJ = new LinkedList<>();
    static int[][] visitedF;
    static Queue<Pair> qF = new LinkedList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        a = new char[r][c];
        visitedJ = new int[r][c];
        visitedF = new int[r][c];

        for(int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'J') {
                    qJ.add(new Pair(i, j));
                    visitedJ[i][j] = 1;
                }
                else if(a[i][j] == 'F') {
                    qF.add(new Pair(i, j));
                    visitedF[i][j] = 1;
                }
            }
        }

        bfs(visitedJ, qJ);
        bfs(visitedF, qF);

        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i != 0 && j != 0 && i != r-1 && j != c-1) {
                    continue;
                }

                if (visitedJ[i][j] != 0) {
                    if (visitedF[i][j] == 0 || visitedJ[i][j] < visitedF[i][j]) {
                        ret = Math.min(ret, visitedJ[i][j]);
                    }
                }

            }
        }

        if(ret == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(ret);
    }

    static void bfs(int[][] visited, Queue<Pair> q) {
        while(!q.isEmpty()) {
            Pair now = q.poll();
            int y = now.y;
            int x = now.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != '#') {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
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
