package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = st.nextToken();
        }

        Arrays.sort(a, (s1, s2) -> {
            if(s1.length() == s2.length()) {
                int i1 = sum(s1);
                int i2 = sum(s2);
                if(i1 == i2) {
                    return s1.compareTo(s2);
                }
                return i1 - i2;
            }
            return s1.length() - s2.length();
        });

        for(String s : a) {
            System.out.println(s);
        }
    }

    static int sum(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c -'0' >= 0 && c - '0' <= 9) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
