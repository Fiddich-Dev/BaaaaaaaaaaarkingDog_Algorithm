package com.fiddich.test.keundol.test11;

import java.util.*;

public class BOJ14391 {

    static int n, m;
    static int[][] a;
    static int[][] visited;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        go(0, 0);

        System.out.println(ret);
    }

    static int calc() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 1) {
                    sb.append(a[i][j]);
                }
                else if(visited[i][j] == 0 && sb.length() != 0) {
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length() != 0) {
                sum += Integer.parseInt(sb.toString());
            }
        }

        // 세로
        for(int i = 0; i < m; i++) { // x
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) { // y
                if(visited[j][i] == 0) {
                    sb.append(a[j][i]);
                }
                else if(visited[j][i] == 1 && sb.length() != 0) {
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length() != 0) {
                sum += Integer.parseInt(sb.toString());
            }
        }

        return sum;
    }

    static void go(int y, int x) {
        if(y == n) {

            ret = Math.max(ret, calc());
//            for(int i = 0; i < n; i++) {
//                for(int j = 0; j < m; j++) {
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
            return;
        }

        visited[y][x] = 1;
        int ny = y;
        int nx = x+1;
        if(nx == m) {
            nx = 0;
            ny = y + 1;
        }
        go(ny, nx);
        visited[y][x] = 0;

        go(ny, nx);
    }
}
