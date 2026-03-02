package com.fiddich.test.keundol.test24;

import java.util.*;

public class BOJ12852 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] prev = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        prev[n] = -1;
        for(int i = n; i >= 2; i--) {
            if(dp[i-1] > dp[i] + 1) {
                dp[i-1] = dp[i] + 1;
                prev[i-1] = i;
            }

            if(i % 2 == 0 && dp[i/2] > dp[i] + 1) {
                dp[i/2] = dp[i] + 1;
                prev[i/2] = i;
            }

            if(i % 3 == 0 && dp[i/3] > dp[i] + 1) {
                dp[i/3] = dp[i] + 1;
                prev[i/3] = i;
            }
        }

        System.out.println(dp[1]);

        List<Integer> ret = new ArrayList<>();
        int now = 1;
        while(now != -1) {
            ret.add(now);
            now = prev[now];
        }

        Collections.reverse(ret);
        for(int i : ret) {
            System.out.print(i + " ");
        }
    }
}
