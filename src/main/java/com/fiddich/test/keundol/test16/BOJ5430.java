package com.fiddich.test.keundol.test16;

import java.util.*;

public class BOJ5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            String command = sc.next();

            int n = sc.nextInt();
            String s = sc.next();
            s = s.substring(1, s.length() - 1);
            String[] temp = s.split(",");
            int[] a = new int[n];
            for(int i= 0; i < n; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            solve(a, command);
        }
    }

    static void solve(int[] a, String command) {
        boolean isReverse = false;
        int l = 0;
        int r = a.length - 1;

        for(char c : command.toCharArray()) {
            if(c == 'R') {
                isReverse = !isReverse;
                continue;
            }

            if(c == 'D') {
                if(l > r) {
                    System.out.println("error");
                    return;
                }

                if(isReverse) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!isReverse) {
            for(int i = l; i <= r; i++) {
                if(i == r) {
                    sb.append(a[i]);
                    continue;
                }
                sb.append(a[i]).append(",");
            }
        }
        else {
            for(int i = r; i >= l; i--) {
                if(i == l) {
                    sb.append(a[i]);
                    continue;
                }
                sb.append(a[i]).append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

}
