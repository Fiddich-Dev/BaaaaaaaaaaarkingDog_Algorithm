package com.fiddich.test.keundol.test4;

import java.util.*;

public class BOJ10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = new int[26];
        for(char c : s.toCharArray()) {
            a[c - 'a']++;
        }

        for(int i : a) {
            System.out.print(i + " ");
        }
    }
}
