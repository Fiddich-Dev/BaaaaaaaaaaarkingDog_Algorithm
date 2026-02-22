package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());
            a[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(a);

        long ret = 0;
        int cnt = 0;
        for(long num : a) {
            int count = map.get(num);

            if(cnt < count) {
                cnt = count;
                ret = num;
            }
        }

        System.out.println(ret);
    }
}
