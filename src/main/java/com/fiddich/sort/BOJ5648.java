package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ5648 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            a[i] = reverse(s);
        }

        Arrays.sort(a);
        for(long l : a) {
            System.out.println(l);
        }
    }

    static long reverse(String str) {
        long sum = 0;
        long now = 1;
        for(int i = 0; i < str.length(); i++) {
            sum += (long) (str.charAt(i) - '0') * now;
            now *= 10;
        }
        return sum;
    }
}

