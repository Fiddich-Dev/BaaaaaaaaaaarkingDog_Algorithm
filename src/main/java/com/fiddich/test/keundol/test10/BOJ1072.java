package com.fiddich.test.keundol.test10;

import java.util.*;

public class BOJ1072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt(); // 게임 횟수
        long y = sc.nextInt(); // 이긴 게임 횟수
        long init = y * 100 / x;

        long l = 1;
        long r = x;
        long ret = Long.MAX_VALUE;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long value = (y + mid) * 100 / (x + mid);
            if(value > init) {
                ret = Math.min(ret, mid);
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        if(ret == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }
}
