package com.fiddich.simulation;

import java.util.*;

public class BOJ20056 {

    static int n, m, k;
    static Queue<Fireball>[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new LinkedList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            map[r][c].add(new Fireball(m, s, d));
        }

        for(int i = 0; i < k; i++) {
            move();
            spray();
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(Fireball fireball : map[i][j]) {
                    ret += fireball.m;
                }
            }
        }

        System.out.println(ret);
    }

    static void spray() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = map[i][j].size();
                if(size < 2) {
                    continue;
                }

                int sumM = 0;
                int sumS = 0;
                int[] cnt = new int[2];

                for(int k = 0; k < size; k++) {
                    Fireball f = map[i][j].poll();
                    sumM += f.m;
                    sumS += f.s;
                    cnt[f.d % 2]++;
                }

                if(sumM / 5 == 0) {
                    continue;
                }

                int nd = 1;
                if(cnt[0] == size || cnt[1] == size) {
                    nd = 0;
                }

                for(int k = 0; k < 4; k++) {
                    map[i][j].add(new Fireball(sumM / 5, sumS / size, nd));
                    nd += 2;
                }
            }
        }
    }

    static void move() {
        Queue<Fireball>[][] newMap = new LinkedList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newMap[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                while (!map[i][j].isEmpty()) {
                    Fireball f = map[i][j].poll();
                    int y = i;
                    int x = j;
                    int m = f.m;
                    int s = f.s;
                    int d = f.d;

                    int ny = ((y + dy[d] * s) % n + n) % n;
                    int nx = ((x + dx[d] * s) % n + n) % n;
                    newMap[ny][nx].add(new Fireball(m, s, d));
                }
            }
        }
        map = newMap;
    }

    static class Fireball {
        int m;
        int s;
        int d;

        public Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
