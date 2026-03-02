package com.fiddich.test.keundol.test21;

import java.util.*;

public class BOJ15683 {

    static int n, m;
    static int[][] a;
    static List<CCTV> cctv = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
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

    static void go(int now) {
        if(now == cctv.size()) {
            ret = Math.min(ret, calc());
            return;
        }

        int y = cctv.get(now).y;
        int x = cctv.get(now).x;
        int num = cctv.get(now).num;

        if(num == 5) {
            fill(y, x, 0, 1);
            fill(y, x, 1, 1);
            fill(y, x, 2, 1);
            fill(y, x, 3, 1);
            go(now+1);
            fill(y, x, 0, -1);
            fill(y, x, 1, -1);
            fill(y, x, 2, -1);
            fill(y, x, 3, -1);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(num == 1) {
                fill(y, x, i, 1);
                go(now+1);
                fill(y, x, i, -1);
            }
            else if(num == 2) {
                fill(y, x, i, 1);
                fill(y, x, (i+2) % 4, 1);
                go(now+1);
                fill(y, x, i, -1);
                fill(y, x, (i+2) % 4, -1);
            }
            else if(num == 3) {
                fill(y, x, i, 1);
                fill(y, x, (i+1) % 4, 1);
                go(now+1);
                fill(y, x, i, -1);
                fill(y, x, (i+1) % 4, -1);
            }
            else if(num == 4) {
                fill(y, x, i, 1);
                fill(y, x, (i+1) % 4, 1);
                fill(y, x, (i+2) % 4, 1);
                go(now+1);
                fill(y, x, i, -1);
                fill(y, x, (i+1) % 4, -1);
                fill(y, x, (i+2) % 4, -1);
            }
        }
    }

    static void fill(int y, int x, int dir, int num) {
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
