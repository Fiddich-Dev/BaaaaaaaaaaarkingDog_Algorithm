package com.fiddich.test.keundol.test21;

import java.util.*;

public class BOJ12100 {

    static int n;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        go(0);

        System.out.println(ret);
    }

    static int calc() {
        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret = Math.max(ret, a[i][j]);
            }
        }
        return ret;
    }

    static void go(int now) {

        ret = Math.max(ret, calc());

        if(now == 5) {
            return;
        }

        for(int i = 0; i < 4; i++) {
            int[][] prev = cloneMap();
            if(i == 0) {
                rotate270();
                push();
                rotate90();
            }
            else if(i == 1) {
                rotate180();
                push();
                rotate180();
            }
            else if(i == 2) {
                rotate90();
                push();
                rotate270();
            }
            else {
                push();
            }
            go(now+1);
            a = prev;
        }
    }

    static int[][] cloneMap() {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret[i][j] = a[i][j];
            }
        }
        return ret;
    }

    static void push() {
        for(int i = 0; i < n; i++) {
            Queue<Integer> nums = new LinkedList<>();
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 0) {
                    continue;
                }
                nums.add(a[i][j]);
            }

            if(nums.isEmpty()) {
                continue;
            }

            List<Integer> newList = new ArrayList<>();
            int prev = nums.poll();
            while(!nums.isEmpty()) {
                int now = nums.poll();
                if(prev == 0) {
                    prev = now;
                }
                else if(prev == now) {
                    newList.add(prev * 2);
                    prev = 0;
                }
                else {
                    newList.add(prev);
                    prev = now;
                }
            }

            if(prev != 0) {
                newList.add(prev);
            }

            Arrays.fill(a[i], 0);
            for(int j = 0; j < newList.size(); j++) {
                a[i][j] = newList.get(j);
            }
        }
    }

    static void rotate90() {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret[j][n-1-i] = a[i][j];
            }
        }
        a = ret;
    }

    static void rotate180() {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret[n-1-i][n-1-j] = a[i][j];
            }
        }
        a = ret;
    }

    static void rotate270() {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret[n-1-j][i] = a[i][j];
            }
        }
        a = ret;
    }

}
