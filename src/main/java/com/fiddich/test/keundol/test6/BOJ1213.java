package com.fiddich.test.keundol.test6;

import java.util.*;

public class BOJ1213 {

    static int[] a = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(char c : s.toCharArray()) {
            a[c - 'A']++;
        }

        if(!isValid(s)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String ret = "";
        String temp = "";
        for(int i = 0; i < 26; i++) {
            if(a[i] % 2 == 1) {
                temp = String.valueOf((char) (i + 'A'));
            }
            for(int j = 0; j < a[i] / 2; j++) {
                ret += String.valueOf((char) (i + 'A'));
            }
        }

        ret += temp;

        for(int i = 25; i >= 0; i--) {
            for(int j = 0; j < a[i] / 2; j++) {
                ret += String.valueOf((char) (i + 'A'));
            }
        }

        System.out.println(ret);
    }

    static boolean isValid(String s) {
        if(s.length() % 2 == 0) {
            for(int i = 0; i < 26; i++) {
                if(a[i] % 2 == 1) {
                    return false;
                }
            }
        }
        else {
            int cnt = 0;
            for(int i = 0; i < 26; i++) {
                if(a[i] % 2 == 1) {
                    cnt++;
                }
            }

            if(cnt != 1) {
                return false;
            }
        }
        return true;
    }
}
