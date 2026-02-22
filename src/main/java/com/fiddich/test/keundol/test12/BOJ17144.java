package com.fiddich.test.keundol.test12;

import java.util.*;

public class BOJ17144 {

    static int r, c, t;
    static int[][] a;
    static Pair air1;
    static Pair air2;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        a = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == -1) {
                    if(air1 == null) {
                        air1 = new Pair(i, j);
                    }
                    else {
                        air2 = new Pair(i, j);
                    }
                }
            }
        }

        for(int i = 0; i < t; i++) {
            spread();

            print();

            int[] dy1 = {0, -1, 0, 1};
            int[] dx1 = {1, 0, -1, 0};
            move(air1, dy1, dx1);

            int[] dy2 = {0, 1, 0, -1};
            int[] dx2 = {1, 0, -1, 0};
            move(air2, dy2, dx2);
        }

        System.out.println(calc());
    }

    static void print() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int calc() {
        int sum = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(a[i][j] > 0) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    static void move(Pair air, int[] dy, int[] dx) {
        int y = air.y;
        int x = air.x;

        List<Integer> list = new ArrayList<>();
        int dir = 0;
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                dir++;
            }
            ny = y + dy[dir];
            nx = x + dx[dir];
            if(ny == air.y && nx == air.x) {
                break;
            }

            list.add(a[ny][nx]);
            y = ny;
            x = nx;
        }

        y = air.y;
        x = air.x + 1;
        dir = 0;
        a[y][x] = 0;
        int cur = 0;
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                dir++;
            }
            ny = y + dy[dir];
            nx = x + dx[dir];

            if(ny == air.y && nx == air.x) {
                break;
            }

            a[ny][nx] = list.get(cur);
            cur++;

            y = ny;
            x = nx;
        }
    }

    // -1은 못퍼짐
    static void spread() {
        int[][] newMap = new int[r][c];
        newMap[air1.y][air1.x] = -1;
        newMap[air2.y][air2.x] = -1;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(a[i][j] == 0 || a[i][j] == -1) {
                    continue;
                }

                int mid = a[i][j];
                int temp = a[i][j] / 5;
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || nx < 0 || ny >= r || nx >= c || a[ny][nx] == -1) {
                        continue;
                    }
                    newMap[ny][nx] += temp;
                    mid -= temp;
                }
                newMap[i][j] += mid;
            }
        }

        a = newMap;
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
