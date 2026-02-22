package com.fiddich.test.keundol.test11;

import java.util.*;

public class BOJ1062 {

    static int n, k;
    static String[] a;
    static int[] alpha = new int[26];
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
        }

        alpha['a' - 'a'] = 1;
        alpha['n' - 'a'] = 1;
        alpha['t' - 'a'] = 1;
        alpha['i' - 'a'] = 1;
        alpha['c' - 'a'] = 1;

        if(k < 5) {
            System.out.println(0);
            return;
        }

        combi(-1, 5);

        System.out.println(ret);
    }

    static boolean isValid(String s) {
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            if(alpha[idx] == 0) {
                return false;
            }
        }
        return true;
    }

    static void combi(int start, int cnt) {
        if(cnt == k) {
            int temp = 0;
            for(int i = 0; i < n; i++) {
                String s = a[i].substring(4, a[i].length() - 4);
                if(isValid(s)) {
                    temp++;
                }
            }
            ret = Math.max(ret, temp);
            return;
        }
        for(int i = start+1; i < 26; i++) {
            if(alpha[i] == 1) {
                continue;
            }

            alpha[i] = 1;
            cnt++;

            combi(i, cnt);

            cnt--;
            alpha[i] = 0;
        }
    }
}
