package com.fiddich.test.keundol.test7;

import java.util.*;

public class BOJ14405 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cur = 0;
        while(cur < s.length()) {
            char c = s.charAt(cur);
            if(c == 'p') {
                int next = cur + 2;
                if(next > s.length()) {
                    System.out.println("NO");
                    return;
                }
                String temp = s.substring(cur, next);
                if(temp.equals("pi")) {
                    cur = next;
                    continue;
                }
                System.out.println("NO");
                return;
            }
            else if(c == 'k') {
                int next = cur + 2;
                if(next > s.length()) {
                    System.out.println("NO");
                    return;
                }
                String temp = s.substring(cur, next);
                if(temp.equals("ka")) {
                    cur = next;
                    continue;
                }
                System.out.println("NO");
                return;
            }
            else if(c == 'c') {
                int next = cur + 3;
                if(next > s.length()) {
                    System.out.println("NO");
                    return;
                }
                String temp = s.substring(cur, next);
                if(temp.equals("chu")) {
                    cur = next;
                    continue;
                }
                System.out.println("NO");
                return;
            }
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
