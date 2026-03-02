package com.fiddich.test.keundol.test21;

import java.util.*;

public class BOJ2636 {

    static int n, m;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        int ret2 = 0;
        int ret = -1;
        visited[0][0] = 1;
        q.add(new Pair(0, 0));
        while(true) {
            Queue<Pair> q_temp = new LinkedList<>();
            ret++;
            while(!q.isEmpty()) {
                Pair p = q.poll();
                int y = p.y;
                int x = p.x;
                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(visited[ny][nx] == 0) {
                        if(a[ny][nx] == 0) {
                            q.add(new Pair(ny, nx));
                            visited[ny][nx] = visited[y][x] + 1;
                        }
                        else if(a[ny][nx] == 1) {
                            q_temp.add(new Pair(ny, nx));
                            visited[ny][nx] = visited[y][x] + 1;
                        }
                    }
                }
            }

            if(q_temp.isEmpty()) {
                break;
            }

            q = q_temp;
            ret2 = q_temp.size();
        }

        System.out.println(ret);
        System.out.println(ret2);
    }

    static class Pair {
        int y;
        int x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
