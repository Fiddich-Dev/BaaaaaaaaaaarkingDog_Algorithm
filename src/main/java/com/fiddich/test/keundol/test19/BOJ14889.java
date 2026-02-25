package com.fiddich.test.keundol.test19;

import java.util.*;

public class BOJ14889 {

    static int n;
    static int[][] a;
    static int sum;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                sum += a[i][j];
            }
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);
        System.out.println(ret);
    }

    static int calc(List<Integer> b) {
        int[] visited = new int[n];
        for(int i : b) {
            visited[i] = 1;
        }

        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) {
                team1.add(i);
            }
            else {
                team2.add(i);
            }
        }

        int score1 = 0;
        int score2 = 0;
        for(int i = 0; i < n/2; i++) {
            for(int j = i+1; j < n/2; j++) {
                score1 += a[team1.get(i)][team1.get(j)];
                score1 += a[team1.get(j)][team1.get(i)];

                score2 += a[team2.get(i)][team2.get(j)];
                score2 += a[team2.get(j)][team2.get(i)];
            }
        }

        return Math.abs(score1 - score2);
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == n/2) {
            int temp = calc(b);
            ret = Math.min(ret, temp);
            return;
        }
        for(int i = start + 1; i < n; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }
}
