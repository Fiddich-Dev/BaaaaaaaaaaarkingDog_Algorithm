package com.fiddich.simulation;

import java.util.*;

public class BOJ15683 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static int[][] map;
    static List<Pair> cctv = new ArrayList<>();
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= 1 && a[i][j] <= 5) {
                    cctv.add(new Pair(i, j));
                }
            }
        }

        go(0);

        System.out.println(ret);
    }

    static void go(int now) {
        if(now == cctv.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 0 && a[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ret = Math.min(ret, cnt);
            return;
        }


        int y = cctv.get(now).y;
        int x = cctv.get(now).x;
        int num = a[y][x];

        for(int i = 0; i < 4; i++) {
            if(num == 1) {
                // 6이면 멈춰야함 나머지는 상관없음
                // 더해야함 바꾸면 백트래킹 할떄 다른 데이터도 지워짐
                checker(y, x, num, i, 1);
                go(now + 1);
                checker(y, x, num, i, -1);
            }
            else if(num == 2) {
                checker(y, x, num, i, 1);
                checker(y, x, num, (i+2) % 4, 1);
                go(now + 1);
                checker(y, x, num, i, -1);
                checker(y, x, num, (i+2) % 4, -1);
            }
            else if(num == 3) {
                checker(y, x, num, i, 1);
                checker(y, x, num, (i+1) % 4, 1);
                go(now + 1);
                checker(y, x, num, i, -1);
                checker(y, x, num, (i+1) % 4, -1);
            }
            else if(num == 4) {
                checker(y, x, num, i, 1);
                checker(y, x, num, (i+1) % 4, 1);
                checker(y, x, num, (i+2) % 4, 1);
                go(now + 1);
                checker(y, x, num, i, -1);
                checker(y, x, num, (i+1) % 4, -1);
                checker(y, x, num, (i+2) % 4, -1);
            }
            else if(num == 5) {
                checker(y, x, num, i, 1);
                checker(y, x, num, (i+1) % 4, 1);
                checker(y, x, num, (i+2) % 4, 1);
                checker(y, x, num, (i+3) % 4, 1);
                go(now + 1);
                checker(y, x, num, i, -1);
                checker(y, x, num, (i+1) % 4, -1);
                checker(y, x, num, (i+2) % 4, -1);
                checker(y, x, num, (i+3) % 4, -1);
            }

        }
    }

    static void checker(int y, int x, int num, int dir, int isFill) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0  || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 6) {
                break;
            }
            map[ny][nx] += num * isFill;
            y = ny;
            x = nx;
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
