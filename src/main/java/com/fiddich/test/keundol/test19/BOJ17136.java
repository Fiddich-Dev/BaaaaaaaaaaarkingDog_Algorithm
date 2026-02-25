package com.fiddich.test.keundol.test19;

import java.util.*;

public class BOJ17136 {

    static int[][] a = new int[10][10];
    static int[][] visited = new int[10][10];
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[] remain = new int[6];
        Arrays.fill(remain, 5);
        go(remain, 0, 0,0);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }

    static void go(int[] remain, int y, int x, int cnt) {
        if(cnt > ret) {
            return;
        }

        if(y == 10) {
            ret = Math.min(ret, cnt);
            return;
        }

        int nx = x + 1;
        int ny = y;
        if(nx == 10) {
            nx = 0;
            ny++;
        }

        if(a[y][x] == 1) {
            for(int i = 1; i <= 5; i++) {
                if(remain[i] == 0) {
                    continue;
                }

                if(canPush(y, x, i)) {
                    remain[i]--;
                    fill(y, x, i);

                    go(remain, ny, nx, cnt+1);

                    unfill(y, x, i);
                    remain[i]++;
                }
            }
        }
        else {
            go(remain, ny, nx, cnt);
        }
    }

    static void fill(int y, int x, int l) {
        for(int i = y; i < y+l; i++) {
            for(int j = x; j < x+l; j++) {
                a[i][j] = 0;
                visited[i][j] = 1;
            }
        }
    }

    static void unfill(int y, int x, int l) {
        for(int i = y; i < y+l; i++) {
            for(int j = x; j < x+l; j++) {
                a[i][j] = 1;
                visited[i][j] = 0;
            }
        }
    }

    static boolean canPush(int y, int x, int l) {
        if(y + l - 1 >= 10 || x + l - 1 >= 10) {
            return false;
        }

        for(int i = y; i < y+l; i++) {
            for(int j = x; j < x+l; j++) {
                if(a[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
