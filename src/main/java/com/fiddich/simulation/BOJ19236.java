package com.fiddich.simulation;

import java.util.*;

public class BOJ19236 {

    static Info[][] map = new Info[4][4];
    static Pair[] fishes = new Pair[16];
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static Shark shark;
    static int score = 0;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int num = sc.nextInt() - 1;
                int dir = sc.nextInt() - 1;
                map[i][j] = new Info(num, dir);
                fishes[num] = new Pair(i, j);
            }
        }

        shark = new Shark(0, 0, map[0][0].dir);
        score += map[0][0].num + 1;
        map[0][0].isDeath = true;

        solve(map, fishes, 0, 0, map[0][0].dir, score);

        System.out.println(ret);

    }

    static void moveFishes(Info[][] map, Pair[] fishes, int sy, int sx) {
        for(Pair fish : fishes) {
            int y = fish.y;
            int x = fish.x;
            int dir = map[y][x].dir;

            if(map[y][x].isDeath) {
                continue;
            }

            for(int i = 0; i < 8; i++) {
                int nDir = (dir + i) % 8;
                int ny = y + dy[nDir];
                int nx = x + dx[nDir];
                if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || (ny == sy && nx == sx)) {
                    continue;
                }

                moveFish(map, fishes, y, x, ny, nx, nDir);
                break;
            }
        }
    }

    static void moveFish(Info[][] map, Pair[] fishes, int y, int x, int ny, int nx, int nDir) {
        map[y][x].dir = nDir;
        Info temp = map[y][x];
        map[y][x] = map[ny][nx];
        map[ny][nx] = temp;

        fishes[map[ny][nx].num] = new Pair(ny, nx);
        fishes[map[y][x].num] = new Pair(y, x);
    }

    static List<Pair> canEatPos(Info[][] map, int sy, int sx, int sd) {
        List<Pair> result = new ArrayList<>();
        for(int i = 1; i < 4; i++) {
            int ny = sy + dy[sd] * i;
            int nx = sx + dx[sd] * i;
            if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4) {
                break;
            }
            if(map[ny][nx].isDeath) {
                continue;
            }
            result.add(new Pair(ny, nx));
        }
        return result;
    }

    static Pair[] cloneFishes(Pair[] fishes) {
        Pair[] prevFishes = new Pair[16];
        for(int i = 0; i < 16; i++) {
            prevFishes[i] = new Pair(fishes[i].y, fishes[i].x);
        }
        return prevFishes;
    }

    static Info[][] cloneMap(Info[][] map) {
        Info[][] prevMap = new Info[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                prevMap[i][j] = new Info(map[i][j].num, map[i][j].dir, map[i][j].isDeath);
            }
        }
        return prevMap;
    }

    static void solve(Info[][] curMap, Pair[] curFishes, int sy, int sx, int sd, int sum) {

        Info[][] nextMap = cloneMap(curMap);
        Pair[] nextFishes = cloneFishes(curFishes);

        moveFishes(nextMap, nextFishes, sy, sx);

        List<Pair> next = canEatPos(nextMap, sy, sx, sd);

        if(next.isEmpty()) {
            ret = Math.max(ret, sum);
            return;
        }

        for(Pair p : next) {
            int y = p.y;
            int x = p.x;
            int dir = nextMap[y][x].dir;
            int a = nextMap[y][x].num + 1;

            // 물고기 먹기
            nextMap[y][x].isDeath = true;

            solve(nextMap, nextFishes, y, x, dir, sum + a);

            // 원복
            nextMap[y][x].isDeath = false;
        }
    }

    static class Shark {
        int y;
        int x;
        int dir;

        public Shark(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    static class Info {
        int num;
        int dir;
        boolean isDeath;

        public Info(int num, int dir) {
            this.num = num;
            this.dir = dir;
            this.isDeath = false;
        }

        public Info(int num, int dir, boolean isDeath) {
            this.num = num;
            this.dir = dir;
            this.isDeath = isDeath;
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
