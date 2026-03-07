package com.fiddich.test.keundol.test26;

import java.util.*;

public class BOJ1992 {

    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        go(0, 0, n);
    }

    static void go(int y, int x, int length) {
        if(length == 1) {
            System.out.print(a[y][x]);
            return;
        }


        if(canPress(y, x, length)) {
            System.out.print(a[y][x]);
        }
        else {
            System.out.print("(");
            go(y, x, length / 2);
            go(y, x + length/2, length/2);
            go(y + length/2, x, length/2);
            go(y + length/2, x + length/2, length/2);
            System.out.print(")");
        }

    }

    static boolean canPress(int y, int x, int length) {
        int sum = 0;
        for(int i = y; i < y + length; i++) {
            for(int j = x; j < x + length; j++) {
                sum += a[i][j];
            }
        }

        if(sum == 0 || sum == length * length) {
            return true;
        }
        return false;
    }
}
