package com.fiddich.simulation;

import java.util.*;

public class BOJ17837 {

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int n, k;
    static int[][] a;
    static List<Integer>[][] map;
    static Horse[] horses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n][n];
        map = new ArrayList[n][n];
        horses = new Horse[k];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int dir = sc.nextInt() - 1;
            horses[i] = new Horse(y, x, dir);
            map[y][x].add(i);
        }

        int turn = 0;
        while(true) {
            turn++;
            if(turn > 1000) {
                System.out.println(-1);
                return;
            }

            for(int i = 0; i < k; i++) {
                int y = horses[i].y;
                int x = horses[i].x;
                int dir = horses[i].dir;

                List<Integer> noMove = new ArrayList<>();
                List<Integer> move = new ArrayList<>();
                boolean isFind = false;

                for(Integer num : map[y][x]) {
                    if(num == i) {
                        isFind = true;
                    }

                    if(isFind) {
                        move.add(num);
                    }
                    else {
                        noMove.add(num);
                    }
                }


                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) {
                    dir = dir ^ 1;
                    ny = y + dy[dir];
                    nx = x + dx[dir];

                    horses[move.get(0)].dir = dir;
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) {
                        continue;
                    }
                }
                if(a[ny][nx] == 0) {
                    for(Integer num : move) {
                        map[ny][nx].add(num);
                        horses[num].y = ny;
                        horses[num].x = nx;
                    }
                    map[y][x] = noMove;
                }
                if(a[ny][nx] == 1) {
                    Collections.reverse(move);
                    for(Integer num : move) {
                        map[ny][nx].add(num);
                        horses[num].y = ny;
                        horses[num].x = nx;
                    }
                    map[y][x] = noMove;
                }

                if(map[ny][nx].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }


        }


    }

    static class Horse {
        int y;
        int x;
        int dir;

        public Horse(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
// 0 : 흰색, 1 : 빨간색, 2 : 파란색
// 흰색이면 그대로 이동
// 빨간색이면 쌓인 순서 반대로 이동
// 파란색이면 이동방향을 반대로 이동, 그래도 파란색이면 이동X, 칸을 벗어나려고 하면 파란색처럼 취급
// n * n * k * 1000