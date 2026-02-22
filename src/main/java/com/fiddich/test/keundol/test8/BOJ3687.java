package com.fiddich.test.keundol.test8;

import java.util.*;

public class BOJ3687 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] dp = new long[104];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        int[] add = {1, 7, 4, 2, 0, 8};

        for(int i = 9; i <= 100; i++) {
            for(int j = 2; j <= 7; j++) {
                long val = dp[i-j] * 10 + add[j-2];
                dp[i] = Math.min(dp[i], val);
            }
        }


        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            System.out.println(dp[n] + " " + solveMin(n));
        }

    }

    static String solveMin(int n) {
        boolean isOdd = false;
        if(n % 2 != 0) {
            isOdd = true;
        }

        String ret = "";
        if(isOdd) {
            ret += "7";
            n -= 3;
        }

        for(int i = 0; i < n; i += 2) {
            ret += "1";
        }

        return ret;
    }

}

// 큰수는 2, 3으로 계속 나누면 됨


// 2, 3, 4, 5, 6, 7로 n 만들기
