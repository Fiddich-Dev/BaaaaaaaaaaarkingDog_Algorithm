package com.fiddich.test.keundol.test6;

import java.util.*;

public class BOJ1620 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        String[] a = new String[n];
        int m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
            map.put(a[i], i+1);
        }
        for(int i = 0; i < m; i++) {
            String temp = sc.next();
            if(temp.charAt(0) - '0' >= 0 && temp.charAt(0) - '0' <= 9) {
                int num = Integer.parseInt(temp);
                System.out.println(a[num - 1]);
                continue;
            }

            System.out.println(map.get(temp));
        }
    }
}
