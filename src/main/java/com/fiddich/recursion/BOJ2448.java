package com.fiddich.recursion;

import java.util.*;

public class BOJ2448 {

    static char[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        a = new char[n][2*n - 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(a[i], ' ');
        }

        go(n, 0, n-1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n - 1; j++) {
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void go(int h, int y, int x) {
        if(h == 3) {
            a[y][x] = '*';
            a[y+1][x-1] = '*';
            a[y+1][x+1] = '*';
            a[y+2][x-2] = '*';
            a[y+2][x-1] = '*';
            a[y+2][x] = '*';
            a[y+2][x+1] = '*';
            a[y+2][x+2] = '*';
            return;
        }

        go(h/2, y, x);

        go(h/2, y + h/2, x - h/2);
        go(h/2, y + h/2, x + h/2);

    }

}
