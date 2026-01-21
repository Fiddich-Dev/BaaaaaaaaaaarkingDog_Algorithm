package com.fiddich.simulation;

import java.util.*;

public class BOJ19237 {

    static int n, m, k;
    static Info[][] a;
    static int[][][] priority;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Shark[] sharks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        a = new Info[n][n];
        sharks = new Shark[m];
        priority = new int[m][4][4];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                a[i][j] = new Info(0, 0); // 비어있으면
                if(temp != 0) {
                    sharks[temp-1] = new Shark(i, j, -1, false);
                }

            }
        }
        for(int i = 0; i < m; i++) {
            sharks[i].dir = sc.nextInt() - 1;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    priority[i][j][k] = sc.nextInt() - 1;
                }
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        for(int i = 1; i <= 1000; i++) {
            spray();
            move();
            updateSpray();
            killCheck();
            if(isStop()) {
                return i;
            }
        }
        return -1;
    }

    static boolean isStop() {
        for(int i = 1; i < m; i++) {
            if(!sharks[i].isDeath) {
                return false;
            }
        }
        return true;
    }

    static void killCheck() {
        for(int i = 0; i < m; i++) {
            if(sharks[i].isDeath) {
                continue;
            }

            for(int j = i+1; j < m; j++) {
                if(sharks[i].y == sharks[j].y && sharks[i].x == sharks[j].x) {
                    // 숫자가 작은게 이김
                    sharks[j].isDeath = true;
                }
            }
        }
    }

    static void updateSpray() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j].num == 0 && a[i][j].remainTime == 0) {
                    continue;
                }

                a[i][j].remainTime--;
                if(a[i][j].remainTime == 0) {
                    a[i][j] = new Info(0, 0);
                }
            }
        }
    }

    static void move() {
        for(int i = 0; i < m; i++) {
            Shark shark = sharks[i];
            if(shark.isDeath) {
                continue;
            }
            int y = shark.y;
            int x = shark.x;
            int dir = shark.dir;
            boolean isMove = false;
            // 냄새 없는 칸
            for(int j = 0; j < 4; j++) {
                int nDir = priority[i][dir][j];
                int ny = y + dy[nDir];
                int nx = x + dx[nDir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(a[ny][nx].num == 0 && a[ny][nx].remainTime == 0) {
                    shark.y = ny;
                    shark.x = nx;
                    shark.dir = nDir;
                    isMove = true;
                    break;
                }
            }

            if(isMove) {
                continue;
            }

            // 자신의 냄새가 있는 칸
            for(int j = 0; j < 4; j++) {
                int nDir = priority[i][dir][j];
                int ny = y + dy[nDir];
                int nx = x + dx[nDir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(a[ny][nx].num == i + 1) {
                    shark.y = ny;
                    shark.x = nx;
                    shark.dir = nDir;
                    break;
                }
            }
        }
    }

    static void spray() {
        for(int i = 0; i < m; i++) {
            Shark shark = sharks[i];
            if(shark.isDeath) {
                continue;
            }
            int y = shark.y;
            int x = shark.x;

            a[y][x] = new Info(i+1, k);
        }
    }

    static class Shark {
        int y;
        int x;
        int dir;
        boolean isDeath;

        public Shark(int y, int x, int dir, boolean isDeath) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.isDeath = isDeath;
        }
    }

    static class Info {
        int num;
        int remainTime;

        public Info(int num, int remainTime) {
            this.num = num;
            this.remainTime = remainTime;
        }
    }
}
