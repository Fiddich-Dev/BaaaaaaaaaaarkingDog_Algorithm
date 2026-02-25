package com.fiddich.test.keundol.test17;

import java.util.*;

public class BOJ1644 {

    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n == 1) {
            System.out.println(0);
            return;
        }
        a = new int[n+4]; // 0이면 소수

        a[0] = 1;
        a[1] = 1;

        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(a[i] == 1) {
                continue;
            }
            list.add(i);
            int v = 2;
            while(i * v <= n) {
                a[i * v] = 1;
                v++;
            }
        }

        int ret = 0;
        int l = 0;
        int r = 1;
        int sum = list.get(0);
        while(l <= r) {
            if(sum > n) {
                sum -= list.get(l);
                l++;
            }
            else if(sum < n) {
                if(r < list.size()) {
                    sum += list.get(r);
                    r++;
                    continue;
                }
                break;
            }
            else if(sum == n) {
                ret++;
                sum -= list.get(l);
                l++;
            }
        }

        System.out.println(ret);
    }
}
