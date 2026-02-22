package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // 빈도
        Map<Integer, Integer> order = new HashMap<>(); // 순서
        Set<Integer> set = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            order.put(num, order.getOrDefault(num, i));
        }

        Collections.sort(arr, (i1, i2) -> {
            if(map.get(i1).equals(map.get(i2))) {
                return order.get(i1) - order.get(i2);
            }
            return map.get(i2) - map.get(i1);
        });

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
