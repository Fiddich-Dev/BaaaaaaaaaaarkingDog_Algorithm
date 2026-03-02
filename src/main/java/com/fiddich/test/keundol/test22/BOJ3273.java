package com.fiddich.test.keundol.test22;

import java.util.*;

public class BOJ3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[1000004];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            dp[a[i]] = i+1;
        }
        int x = sc.nextInt();

        int ret = 0;
        for(int i = 0; i < n; i++) {
            int target = x - a[i];
            if(target <= 0 || target > 1000000) {
                continue;
            }

            if(dp[a[i]] < dp[target]) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}
