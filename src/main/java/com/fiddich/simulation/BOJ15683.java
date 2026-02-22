package com.fiddich.simulation;

import java.util.*;

public class BOJ15683 {

    static int n, m;
    static int[][] a;
    static List<CCTV> cctv = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= 1 && a[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, a[i][j]));
                }
            }
        }

        go(0);

        System.out.println(ret);
    }

    static void go(int num) {
        if(num == cctv.size()) {
            ret = Math.min(ret, calc());
            return;
        }

        for(int i = 0; i < 4; i++) {
            int[][] clone = copyMap(a);

            fill(cctv.get(num), i);
            go(num + 1);
            a = clone;
        }
    }

    static int calc() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] copyMap(int[][] a) {
        int[][] ret = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ret[i][j] = a[i][j];
            }
        }
        return ret;
    }

    static void fill(CCTV cctv, int dir) {
        int y = cctv.y;
        int x = cctv.x;
        int num = cctv.num;

        if(num == 1) {
            fillLine(y, x, num, dir);
        }
        else if(num == 2) {
            fillLine(y, x, num, dir);
            fillLine(y, x, num, (dir + 2) % 4);
        }
        else if(num == 3) {
            fillLine(y, x, num, dir);
            fillLine(y, x, num, (dir + 1) % 4);
        }
        else if(num == 4) {
            fillLine(y, x, num, dir);
            fillLine(y, x, num, (dir + 1) % 4);
            fillLine(y, x, num, (dir + 2) % 4);
        }
        else if(num == 5) {
            fillLine(y, x, num, dir);
            fillLine(y, x, num, (dir + 1) % 4);
            fillLine(y, x, num, (dir + 2) % 4);
            fillLine(y, x, num, (dir + 3) % 4);
        }
    }

    static void fillLine(int y, int x, int num, int dir) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 6) {
                break;
            }
            a[ny][nx] += num;

            y = ny;
            x = nx;
        }
    }

    static class CCTV {
        int y;
        int x;
        int num;

        public CCTV(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }
}
