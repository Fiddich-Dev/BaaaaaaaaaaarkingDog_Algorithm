package com.fiddich.test.keundol.test12;

import java.util.*;

public class BOJ12869 {

    static int n;
    static int[] a = new int[3];
    static int[][][] visited = new int[64][64][64];
    static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(a[0], a[1], a[2]));
        visited[a[0]][a[1]][a[2]] = 1;

        while(!q.isEmpty()) {
            Info now = q.poll();

            for(int i = 0; i < 6; i++) {
                int na = now.a - attack[i][0];
                int nb = now.b - attack[i][1];
                int nc = now.c - attack[i][2];
                na = Math.max(0, na);
                nb = Math.max(0, nb);
                nc = Math.max(0, nc);
                if(visited[na][nb][nc] == 0) {
                    visited[na][nb][nc] = visited[now.a][now.b][now.c] + 1;
                    q.add(new Info(na, nb, nc));
                }
            }
        }

        System.out.println(visited[0][0][0] - 1);
    }

    static class Info {
        int a;
        int b;
        int c;

        public Info(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
