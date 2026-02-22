package com.fiddich.test.keundol.test13;

import java.util.*;

public class BOJ10709 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];
        int[][] ret = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                ret[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            int cur = -1;
            boolean found = false;
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 'c') {
                    found = true;
                    cur = 0;
                    ret[i][j] = cur;
                    cur++;
                    continue;
                }

                if(found) {
                    ret[i][j] = cur;
                    cur++;
                }
                else {
                    ret[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}
