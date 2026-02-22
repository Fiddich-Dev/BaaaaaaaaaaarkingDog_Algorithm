package com.fiddich.test.keundol.test4;

import java.util.*;

public class BOJ4179 {

    static int r, c;
    static char[][] a;
    static int[][] visitedJ;
    static int[][] visitedF;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> J = new ArrayList<>();
    static List<Pair> F = new ArrayList<>();

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
                    J.add(new Pair(i, j));
                }
                else if(a[i][j] == 'F') {
                    F.add(new Pair(i, j));
                }
            }
        }

        bfs(J, visitedJ);
        bfs(F, visitedF);

//        for(int i = 0; i < r; i++) {
//            for(int j = 0; j < c; j++) {
//                System.out.print(visitedF[i][j] + " ");
//            }
//            System.out.println();
//        }


        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || j == 0 || i == r-1 || j == c-1) {
                    if(visitedJ[i][j] != 0) {
                        if(visitedF[i][j] == 0) {
                            ret = Math.min(ret, visitedJ[i][j]);
                        }
                        else if(visitedJ[i][j] < visitedF[i][j]) {
                            ret = Math.min(ret, visitedJ[i][j]);
                        }
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

    static void bfs(List<Pair> pos, int[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        for(Pair p : pos) {
            q.add(p);
            visited[p.y][p.x] = 1;
        }

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != '#') {
                    visited[ny][nx] = visited[y][x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }
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
