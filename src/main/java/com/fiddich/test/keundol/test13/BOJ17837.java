package com.fiddich.test.keundol.test13;

import java.util.*;

public class BOJ17837 {

    static int n, k;
    static int[][] map;
    static List<Integer>[][] pos;
    static Horse[] horses;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        pos = new ArrayList[n][n];
        horses = new Horse[k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                pos[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int dir = sc.nextInt() - 1;
            horses[i] = new Horse(y, x, dir);
            pos[y][x].add(i);
        }

        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < k; j++) {
                int cnt = move(j);
                if(cnt >= 4) {
                    System.out.println(i+1);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    // 움직인 칸에 말이 쌓인 개수 반환
    static int move(int num) {
        int y = horses[num].y;
        int x = horses[num].x;
        int dir = horses[num].dir;
        // 움직일 말들
        List<Integer> a = find(num);

        // 다음 좌표
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) {
            dir ^= 1;
            ny = y + dy[dir];
            nx = x + dx[dir];
        }
        if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) {
            horses[num].dir = dir;
            pos[y][x].addAll(a);
        }
        else if(map[ny][nx] == 0) {
            changeHorses(ny, nx, dir, a);
            pos[ny][nx].addAll(a);
            return pos[ny][nx].size();
        }
        else if(map[ny][nx] == 1) {
            changeHorses(ny, nx, dir, a);
            for(int i = a.size() - 1; i >= 0; i--) {
                pos[ny][nx].add(a.get(i));
            }
            return pos[ny][nx].size();
        }

        return 0;
    }

    static void changeHorses(int ny, int nx, int nDir, List<Integer> a) {
        for(int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            horses[num].y = ny;
            horses[num].x = nx;

            if(i == 0) {
                horses[num].dir = nDir;
            }
        }
    }

    static List<Integer> find(int num) {
        int y = horses[num].y;
        int x = horses[num].x;
        List<Integer> notMove = new ArrayList<>();
        // num 포함 위에 있는 같이 움직일 말들 찾기
        List<Integer> ret = new ArrayList<>();

        boolean found = false;
        for(int i : pos[y][x]) {
            if(i == num) {
                found = true;
            }
            if(found) {
                ret.add(i);
            }
            else {
                notMove.add(i);
            }
        }
        pos[y][x] = notMove;
        return ret;
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
