package com.fiddich.test.solveac.class2;

import java.util.*;

public class BOJ1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt2 = 0;
        int cnt5 = 0;

        int now = 2;
        while(now <= n) {
            cnt2 += n / now;
            now *= 2;
        }

        now = 5;
        while(now <= n) {
            cnt5 += n / now;
            now *= 5;
        }

        System.out.println(Math.min(cnt2, cnt5));
    }
}
