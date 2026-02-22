package com.fiddich.test.one;

import java.util.*;

public class BOJ10836 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[2 * m - 1];
        for(int i = 0; i < n; i++) {
            int start = 0;

            int cnt1 = sc.nextInt();
            for(int j = start; j < start + cnt1; j++) {
                a[j] += 0;
            }
            start += cnt1;

            int cnt2 = sc.nextInt();
            for(int j = start; j < start + cnt2; j++) {
                a[j] += 1;
            }
            start += cnt2;

            int cnt3 = sc.nextInt();
            for(int j = start; j < start + cnt3; j++) {
                a[j] += 2;
            }
            start += cnt3;
        }

        int[][] map = new int[m][m];
        int sy = m-1;
        int sx = 0;
        int[] dy = {-1, 0};
        int[] dx = {0, 1};
        int dir = 0;
        for(int i = 0; i < 2*m - 1; i++) {
            map[sy][sx] = a[i];

            int ny = sy + dy[dir];
            int nx = sx + dx[dir];
            if(ny < 0 || nx < 0 || ny >= m || nx >= m) {
                dir = (dir + 1) % 2;
                ny = sy + dy[dir];
                nx = sx + dx[dir];
            }
            sy = ny;
            sx = nx;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < m; j++) {
                int temp = Math.max(map[i-1][j], map[i][j-1]);
                temp = Math.max(temp, map[i-1][j-1]);
                map[i][j] = temp;
            }
        }

        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print((map[i][j] + 1) + " ");
            }
            System.out.println();
        }

    }
}
