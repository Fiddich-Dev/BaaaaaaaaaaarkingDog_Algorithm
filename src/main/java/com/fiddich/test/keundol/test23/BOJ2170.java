package com.fiddich.test.keundol.test23;

import java.util.*;
import java.io.*;

public class BOJ2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.from == p2.from) {
                return p1.to - p2.to;
            }
            return p1.from - p2.from;
        });

        int ret = 0;
        int start = a[0].from;
        int end = a[0].to;
        for(int i = 1; i < n; i++) {
            if(end < a[i].from) {
                ret += end - start;
                start = a[i].from;
                end = a[i].to;
            }
            else {
                if(end >= a[i].to) {
                    continue;
                }
                end = a[i].to;
            }
        }

        ret += end - start;

        System.out.println(ret);
    }

    static class Pair {
        int from;
        int to;
        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
