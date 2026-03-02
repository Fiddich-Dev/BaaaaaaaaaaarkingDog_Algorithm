package com.fiddich.test.keundol.test24;

import java.util.*;

public class BOJ2828 {

    static int n, m, j;
    static int l, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        j = sc.nextInt();
        l = 0;
        r = m - 1;

        int ret = 0;
        for(int i = 0; i < j; i++) {
            int idx = sc.nextInt() - 1;
            ret += move(idx);
        }

        System.out.println(ret);
    }

    static int move(int idx) {
        if(idx >= l && idx <= r) {
            return 0;
        }
        if(idx < l) {
            int dis = l - idx;
            l -= dis;
            r -= dis;
            return dis;
        }
        if(idx > r) {
            int dis = idx - r;
            l += dis;
            r += dis;
            return dis;
        }

        return -9999;
    }
}
