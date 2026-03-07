package com.fiddich.test.solveac.class3;

import java.util.*;

public class BOJ1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(int i = 0; i < m; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> ret = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 2) {
                ret.add(key);
            }
        }

        System.out.println(ret.size());
        Collections.sort(ret);
        for(String s : ret) {
            System.out.println(s);
        }
    }
}
