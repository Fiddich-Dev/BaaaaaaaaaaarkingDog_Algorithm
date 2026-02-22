package com.fiddich.test.keundol.test1;

import java.util.*;

public class BOJ15686 {

    static int n, m;
    static int[][] a;
    static List<Pair> c = new ArrayList<>();
    static List<Pair> h = new ArrayList<>();
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) {
                    c.add(new Pair(i, j));
                }
                else if(a[i][j] == 1) {
                    h.add(new Pair(i, j));
                }
            }
        }

        List<Pair> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(ret);
    }

    static int calcDis(List<Pair> b) {
        int sum = 0;
        for(Pair home : h) {
            int min = Integer.MAX_VALUE;
            for(Pair chicken : b) {
                int dis = Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x);
                min = Math.min(min, dis);
            }

            sum += min;
        }
        return sum;
    }

    static void combi(int start, List<Pair> b) {
        if(b.size() == m) {
            ret = Math.min(ret, calcDis(b));
            return;
        }
        for(int i = start+1; i < c.size(); i++) {
            b.add(c.get(i));
            combi(i, b);
            b.remove(b.size() - 1);
        }
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
