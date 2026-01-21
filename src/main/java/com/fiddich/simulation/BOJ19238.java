package com.fiddich.simulation;

import java.util.*;

public class BOJ19238 {

    static int n, m, e;
    static int[][] map;
    static Info taxi = new Info(0, 0, 0, 0);
    static Info[] customers;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        e = sc.nextInt();
        map = new int[n][n];
        customers = new Info[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        taxi.sy = sc.nextInt() - 1;
        taxi.sx = sc.nextInt() - 1;
        for(int i = 0; i < m; i++) {
            customers[i] = new Info(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1);
        }

        for(int i = 0; i < m; i++) {
            if(!solve()) {
                System.out.println(-1);
                return;
            }
//            System.out.println(idx + " : " + e);
        }

        System.out.println(e);
    }

    static boolean solve() {
        if(!moveToCustomer()) {
            return false;
        }
        if(!moveToGoal()) {
            return false;
        }
        return true;
    }

    static boolean moveToGoal() {
        bfs(taxi.sy, taxi.sx);
        int dis = visited[taxi.ey][taxi.ex] - 1;
        if(dis < 0) {
            return false;
        }
        if(!move(dis)) {
            return false;
        }
        e += dis * 2;
        taxi.sy = taxi.ey;
        taxi.sx = taxi.ex;
        customers[idx] = null;
        return true;
    }

    static boolean moveToCustomer() {
        bfs(taxi.sy, taxi.sx);
        List<Pos> temp = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            if(customers[i] == null) {
                continue;
            }
            int y = customers[i].sy;
            int x = customers[i].sx;
            int dis = visited[y][x] - 1;
            if(dis < 0) {
                continue;
            }
            temp.add(new Pos(y, x, dis, i));
        }

        if(temp.isEmpty()) { // 태울수 있는 승객이 없음
            return false;
        }
        sort(temp);

        Pos p = temp.get(0);
        if(!move(p.dis)) {
            return false;
        }

        taxi = customers[p.idx];
        idx = p.idx;
        return true;
    }

    static boolean move(int dis) {
        if(e < dis) {
            return false;
        }
        e -= dis;
        return true;
    }

    static void sort(List<Pos> temp) {
        Collections.sort(temp, (p1, p2) -> {
            if(p1.dis == p2.dis) {
                if(p1.y == p2.y) {
                    return p1.x - p2.x;
                }
                return p1.y - p2.y;
            }
            return p1.dis - p2.dis;
        });
    }

    static void bfs(int y, int x) {
        visited = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(new Pair(y, x));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int sy = p.y;
            int sx = p.x;

            for(int i = 0; i < 4; i++) {
                int ny = sy + dy[i];
                int nx = sx + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(visited[ny][nx] == 0 && map[ny][nx] == 0) {
                    visited[ny][nx] = visited[sy][sx] + 1;
                    q.add(new Pair(ny, nx));
                }
            }
        }
    }

    static class Pos {
        int y;
        int x;
        int dis;
        int idx;

        public Pos(int y, int x, int dis, int idx) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.idx = idx;
        }
    }

    static class Info {
        int sy;
        int sx;
        int ey;
        int ex;

        public Info(int sy, int sx, int ey, int ex) {
            this.sy = sy;
            this.sx = sx;
            this.ey = ey;
            this.ex = ex;
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
// 손님을 도착지로 데려다줄 때마다 연료가 충전되고, 연료가 바닥나면 그 날의 업무가 끝난다.
// 백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다. 그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다.