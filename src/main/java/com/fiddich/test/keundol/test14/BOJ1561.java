package com.fiddich.test.keundol.test14;

import java.util.*;

public class BOJ1561 {

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[m];
        for(int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

        if (n <= m) {
            System.out.println(n);
            return;
        }

        long l = 0;
        long r = 60_000_000_000L;
        long ret = 0;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            if (isValid(mid)) {
                ret = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        long prevCnt = m;
        for(int i = 0; i < m; i++) {
            prevCnt += (ret - 1) / a[i];
        }

        for(int i = 0; i < m; i++) {
            if(ret % a[i] == 0) {
                prevCnt++;
                if(prevCnt == n) {
                    System.out.println(i+1);
                    return;
                }
            }
        }
    }

    static boolean isValid(long mid) {
        long cnt = m;
        for(int i = 0; i < m; i++) {
            cnt += mid / a[i];
        }
        return cnt >= n;
    }

}
