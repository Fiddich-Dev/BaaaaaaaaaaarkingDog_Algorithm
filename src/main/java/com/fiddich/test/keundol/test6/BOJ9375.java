package com.fiddich.test.keundol.test6;

import java.util.*;

public class BOJ9375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                String name = sc.next();
                String category = sc.next();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int ret = 1;
            for(String s : map.keySet()) {
//                System.out.println(s + " : " + map.get(s));
                ret *= map.get(s) + 1;
            }

            System.out.println(ret - 1);
        }


    }
}
