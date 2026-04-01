package com.fiddich.simulation;

import java.util.*;

public class BOJ17472 {

    static int num = 1;
    static int n, m;
    static int[][] a;
    static int[][] island;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair>[] land;
    static int[][] bridge;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        island = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        makeIsland();

        bridge = new int[num][num];

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                bridge[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < num; i++) {
            for(Pair p : land[i]) {
                int y = p.y;
                int x = p.x;
                int now = island[y][x];
                for(int j = 0; j < 4; j++) {
                    straight(y, x, now, j);
                }
            }
        }

        int[] visited = new int[num];
        visited[1] = 1;
        go(1, 1, 0, visited);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }

    static void go(int now, int cnt, int sum, int[] visited) {
//        System.out.println(now + " : " + sum + " : " + cnt);
        if(cnt == num-1) {
            ret = Math.min(ret, sum);
            return;
        }
        for(int i = 1; i < num; i++) {
            if(bridge[now][i] < Integer.MAX_VALUE && visited[i] == 0) {
                visited[i] = 1;
                go(now, cnt+1, sum + bridge[now][i], visited);
                go(i, cnt+1, sum + bridge[now][i], visited);
                visited[i] = 0;
            }
        }
    }

    static void straight(int y, int x, int now, int dir) {
        int dis = 0;
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            dis++;
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || island[ny][nx] == now) {
                return;
            }
            if(island[ny][nx] > 0 && island[ny][nx] != now) {
                if(dis - 1 <= 1) {
                    return;
                }
                bridge[now][island[ny][nx]] = Math.min(bridge[now][island[ny][nx]], dis - 1);
                return;
            }

            y = ny;
            x = nx;
        }
    }

    static void makeIsland() {
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, visited, num);
                    num++;
                }
            }
        }

        land = new ArrayList[num];
        for(int i = 0; i < num; i++) {
            land[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(island[i][j] > 0) {
                    land[island[i][j]].add(new Pair(i, j));
                }
            }
        }
    }

    static void bfs(int sy, int sx, int[][] visited, int num) {
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pair(sy, sx));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            island[y][x] = num;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }
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
