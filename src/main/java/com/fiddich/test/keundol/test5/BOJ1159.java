package com.fiddich.test.keundol.test5;

import java.util.*;

public class BOJ1159 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        int[] alpha = new int[26];
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
            char c = a[i].charAt(0);
            alpha[c - 'a']++;
        }

        String ret = "";
        for(int i = 0; i < 26; i++) {
            if(alpha[i] >= 5) {
                char c = (char) (i + 'a');
                ret += String.valueOf(c);
            }
        }

        if(ret.length() == 0) {
            System.out.println("PREDAJA");
            return;
        }
        System.out.println(ret);
    }
}
