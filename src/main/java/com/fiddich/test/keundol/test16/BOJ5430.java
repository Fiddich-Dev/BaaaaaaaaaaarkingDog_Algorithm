package com.fiddich.test.keundol.test16;

import java.util.*;

public class BOJ5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            String s = sc.next();
            int n = sc.nextInt();

            String ss = sc.next();
            ss = ss.substring(1, ss.length() - 1);
            String[] temp = ss.split(",");
            int[] a = new int[n];
            for(int i= 0; i < n; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            solve(a, s);
        }
    }

    static void solve(int[] a, String s) {
        boolean isReverse = false;
        int l = 0;
        int r = a.length - 1;
        for(char c : s.toCharArray()) {
            if(c == 'R') {
                isReverse = !isReverse;
            }
            if(c == 'D') {
                if(isReverse) {
                    r--;
                }
                else if(!isReverse) {
                    l++;
                }

                if(l > r) {
                    System.out.println("error");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = l; i <= r; i++) {
            if(i == r) {
                sb.append(a[i]);
                continue;
            }
            sb.append(a[i]).append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
