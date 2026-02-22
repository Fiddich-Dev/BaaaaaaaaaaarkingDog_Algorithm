package com.fiddich.test.keundol.test9;

import java.util.*;

public class BOJ17406 {

    static int n, m, k;
    static int[][] a;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Roll[] roll = new Roll[k];
        for(int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int dis = sc.nextInt();
            roll[i] = new Roll(y, x, dis);
        }

        permutation(0, roll, k, k);
        System.out.println(ret);
    }

    static void solve(Roll[] roll) {
        // 맵 복사
        int[][] map = cloneMap();

        // 맵 회전
        for(int i = 0; i < k; i++) {
            int y = roll[i].y;
            int x = roll[i].x;
            int dis = roll[i].dis;
            for(int j = 1; j <= dis; j++) {
                rotate(map, y, x, j);
            }
        }

        // 값 추출
        ret = Math.min(ret, calc(map));
    }

    static int calc(int[][] map) {
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < m; j++) {
                sum += map[i][j];
            }
            ret = Math.min(ret, sum);
        }

        return ret;
    }

    static int[][] cloneMap() {
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = a[i][j];
            }
        }
        return map;
    }

    static void rotate(int[][] map, int y, int x, int dis) {
        List<Pair> pos = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        Pair start = new Pair(y-dis, x-dis);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 2*dis; j++) {
                pos.add(new Pair(start.y, start.x));
                val.add(map[start.y][start.x]);
                start.y += dy[i];
                start.x += dx[i];
            }
        }

        Collections.rotate(val, 1);


        for(int i = 0; i < pos.size(); i++) {
            Pair p = pos.get(i);
            map[p.y][p.x] = val.get(i);
        }
    }

    static void permutation(int depth, Roll[] roll, int n, int r) {
        if(depth == r) {
            solve(roll);
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(roll, depth, i);
            permutation(depth+1, roll, n, r);
            swap(roll, depth, i);
        }
    }

    static void swap(Roll[] roll, int a, int b) {
        Roll temp = roll[a];
        roll[a] = roll[b];
        roll[b] = temp;
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Roll {
        int y;
        int x;
        int dis;

        public Roll(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }
    }
}
