package com.fiddich.test.keundol.test15;

import java.util.*;

public class BOJ3197 {

    static int r, c;
    static char[][] a;
    static Pair swan;
    static int[][] visited, visited_swan;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Queue<Pair> waterQ = new LinkedList<>();
    static Queue<Pair> water_tempQ = new LinkedList<>();
    static Queue<Pair> swanQ = new LinkedList<>();
    static Queue<Pair> swan_tempQ = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        a = new char[r][c];
        visited = new int[r][c];
        visited_swan = new int[r][c];
        for(int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'L') {
                    swan = new Pair(i, j);
                }
                if(a[i][j] == '.' || a[i][j] == 'L') {
                    visited[i][j] = 1;
                    waterQ.add(new Pair(i, j));
                }
            }
        }

        // 백조의 시작점
        swanQ.add(new Pair(swan.y, swan.x));
        visited_swan[swan.y][swan.x] = 1;

        int day = 0;
        while(true) {
            if(isMeet()) {
                break;
            }

            waterMelting();

            waterQ = water_tempQ;
            swanQ = swan_tempQ;
            water_tempQ = new LinkedList<>();
            swan_tempQ = new LinkedList<>();

            day++;
        }

        System.out.println(day);
    }

    static void waterMelting() {
        while(!waterQ.isEmpty()) {
            Pair p = waterQ.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if(visited[ny][nx] == 0) {
                    if(a[ny][nx] == 'X') {
                        visited[ny][nx] = 1;
                        water_tempQ.add(new Pair(ny, nx));
                        a[ny][nx] = '.';
                    }
                }
            }
        }
    }

    static boolean isMeet() {
        while(!swanQ.isEmpty()) {
            Pair p = swanQ.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if(visited_swan[ny][nx] == 0) {
                    if(a[ny][nx] == '.') {
                        swanQ.add(new Pair(ny, nx));
                        visited_swan[ny][nx] = 1;
                    }
                    else if(a[ny][nx] == 'X') {
                        swan_tempQ.add(new Pair(ny, nx));
                        visited_swan[ny][nx] = 1;
                    }
                    else if(a[ny][nx] == 'L') {
                        return true;
                    }
                }
            }
        }

        return false;
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
