package com.fiddich.test.keundol.test10;

import java.util.*;

public class BOJ17143 {

    static int r, c, m;
    static List<Info>[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Shark> sharks = new ArrayList<>();
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        m = sc.nextInt();
        map = new ArrayList[r][c];
        initMap();

        for(int i = 0; i < m; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int s = sc.nextInt();
            int d = sc.nextInt() - 1;
            int z = sc.nextInt();
            sharks.add(new Shark(y, x, s, d, z));
            map[y][x].add(new Info(s, d, z));
        }

        for(int i = 0; i < c; i++) {
            hit(i); // 상어를 찾아 맵에서 지우고 배열에서도 삭제
            move();
            eat();
        }

        System.out.println(ret);
    }

    static void move() {
        initMap();

        for(int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);

            int y = shark.y;
            int x = shark.x;
            int s = shark.s;
            int d = shark.d;
            int z = shark.z;

            int dis;
            int ny = y;
            int nx = x;
            if(d == 0 || d == 1) {
                dis = s % (2 * (r - 1));
                ny = nextY(y, d, dis, i);
            }
            else {
                dis = s % (2 * (c - 1));
                nx = nextX(x, d, dis, i);
            }

            int nDir = shark.d;
            // dir은 이미 바꿈
            map[ny][nx].add(new Info(s, nDir, z));
            shark.y = ny;
            shark.x = nx;
        }
    }

    static void eat() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j].size() > 1) {
                    Collections.sort(map[i][j], (i1, i2) -> {
                        return i2.z - i1.z;
                    });

                    for(int k = map[i][j].size() - 1; k >= 1; k--) {
                        int size = map[i][j].get(k).z;
                        kill(size);
                        map[i][j].remove(k);
                    }
                }
            }
        }
    }

    static int nextY(int y, int dir, int dis, int idx) {
        int prev = y;
        for(int i = 0; i < dis; i++) {
            int ny = prev + dy[dir];
            if(ny < 0 || ny >= r) {
                dir ^= 1;
                ny = prev + dy[dir];
            }
            prev = ny;
        }
        sharks.get(idx).d = dir;
        return prev;
    }

    static int nextX(int x, int dir, int dis, int idx) {
        int prev = x;
        for(int i = 0; i < dis; i++) {
            int nx = prev + dx[dir];
            if(nx < 0 || nx >= c) {
                dir ^= 1;
                nx = prev + dx[dir];
            }
            prev = nx;
        }
        sharks.get(idx).d = dir;
        return prev;
    }

    static void hit(int x) {
        for(int i = 0; i < r; i++) {
            if(!map[i][x].isEmpty()) {
                int size = map[i][x].get(0).z;
                ret += size;
                map[i][x] = new ArrayList<>();
                kill(size);
                return;
            }
        }
    }

    static void kill(int size) {
        for(int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            if(shark.z == size) {
                sharks.remove(i);
                return;
            }
        }
    }

    static void initMap() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
    }


    static class Info {
        int s;
        int d;
        int z;

        public Info(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static class Shark {
        int y;
        int x;
        int s;
        int d;
        int z;

        public Shark(int y, int x, int s, int d, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
