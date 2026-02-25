package com.fiddich.test.keundol.test17;

import java.util.*;

public class BOJ15684 {

    static int n, m, h;
    static int[][] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        a = new int[h][n];
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            a[r][c] = 1;
        }

        go(0, 0, 0);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }

    static void go(int y, int x, int cnt) {
        if(isValid()) {
            ret = Math.min(ret, cnt);
        }

        if(cnt == 3) {
            return;
        }
        if(y == h) {
            return;
        }

        int nx = x+1;
        if(nx == n-1) {
            nx = 0;
        }
        int ny = y;
        if(nx == 0) {
            ny++;
        }

        if(a[y][x] != 1 && a[y][x+1] != 1) {
            a[y][x] = 1;
            go(ny, nx, cnt+1);
            a[y][x] = 0;
        }

        go(ny, nx, cnt);
    }

    static boolean isValid() {
        for(int i = 0; i < n; i++) {
            int cur = i;
            for(int j = 0; j < h; j++) {
                if(a[j][cur] == 1) {
                    cur++;
                }
                else if(cur > 0 && a[j][cur - 1] == 1) {
                    cur--;
                }
            }

            if(cur != i) {
                return false;
            }
        }
        return true;
    }
}
