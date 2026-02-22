package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        List<String> a = new ArrayList<>(set);

        Collections.sort(a, (s1, s2) -> {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });
        for(String s : a) {
            System.out.println(s);
        }
    }
}
