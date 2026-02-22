package com.fiddich.test.keundol.test13;

import java.util.*;

public class BOJ14620 {

    static int n;
    static int[][] a;
    static List<Pair> list = new ArrayList<>();
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < n-1; j++) {
                list.add(new Pair(i, j));
            }
        }


        List<Pair> v = new ArrayList<>();
        combi(-1, v);
        System.out.println(ret);
    }

    static int isValid(List<Pair> b) {
        int[][] visited = new int[n][n];
        int sum = 0;
        for(Pair p : b) {
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 5; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(visited[ny][nx] == 1) {
                    return -1;
                }
                sum += a[ny][nx];
                visited[ny][nx] = 1;
            }
        }
        return sum;
    }

    static void combi(int start, List<Pair> b) {
        if(b.size() == 3) {
            int price = isValid(b);
            if(price != -1) {
                ret = Math.min(ret, price);
            }
            return;
        }
        for(int i = start+1; i < list.size(); i++) {
            int y = list.get(i).y;
            int x = list.get(i).x;
            b.add(new Pair(y, x));

            combi(i, b);

            b.remove(b.size() - 1);
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
