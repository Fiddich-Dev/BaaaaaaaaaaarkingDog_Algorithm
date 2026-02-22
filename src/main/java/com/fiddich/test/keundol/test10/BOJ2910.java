package com.fiddich.test.keundol.test10;

import java.util.*;

public class BOJ2910 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n = sc.nextInt();
        int c = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            a.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            map2.put(num, map2.getOrDefault(num, i));
        }

        Collections.sort(a, (i1, i2) -> {
            if(map.get(i1).equals(map.get(i2))) {
                return map2.get(i1) - map2.get(i2);
            }
            return map.get(i2) - map.get(i1);
        });

        for(int i : a) {
            System.out.print(i + " ");
        }
    }
}
