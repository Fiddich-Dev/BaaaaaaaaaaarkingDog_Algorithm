package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ10825 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Info[] arr = new Info[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (i1, i2) -> {
            if(i1.a == i2.a) {
                if(i1.b == i2.b) {
                    if(i1.c == i2.c) {
                        return i1.name.compareTo(i2.name);
                    }
                    return i2.c - i1.c;
                }
                return i1.b - i2.b;
            }
            return i2.a - i1.a;
        });

        for(Info i : arr) {
            System.out.println(i.name);
        }
    }

    static class Info {
        String name;
        int a;
        int b;
        int c;

        public Info(String name, int a, int b, int c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
