package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ16234 {

    static int n, l, r;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        a = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret = 0;
        while(true) {
            visited = new int[n][n];
            int sum = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] == 0) {
                        bfs(i, j); // 탐색한 곳들의 평균으로 인구수 변경
                        sum++;
                    }
                }
            }

            if(sum == n*n) {
                break;
            }
            ret++;
        }

        System.out.println(ret);
    }

    static void bfs(int sy, int sx) {
        List<Pair> list = new ArrayList<>();
        int sum = 0;

        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pair(sy, sx));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            list.add(new Pair(y, x));
            int cur = a[y][x];
            sum += cur;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                int next = a[ny][nx];
                int dis = Math.abs(next - cur);
                if(visited[ny][nx] == 0 && dis >= l && dis <= r) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }

        // 인구이동
        int temp = sum / list.size();
        for(Pair p : list) {
            a[p.y][p.x] = temp;
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
