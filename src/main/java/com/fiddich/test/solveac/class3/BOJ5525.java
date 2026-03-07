package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ5525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();

        int[] dp = new int[m];
        for(int i = 0; i <= m-3; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I') {
                dp[i] = 1;
            }
        }

        int ret = 0;
        int count = 0;
        for(int i = 0; i <= m-3; i++) {
            if(dp[i] == 1) {
                count++;

                if(count == n) {
                    ret++;
                    count--;
                }
                i++;
            }
            else {
                count = 0;
            }
        }

        System.out.println(ret);
    }
}
