package com.fiddich.test.keundol.test16;

import java.util.*;
import java.io.*;

public class BOJ17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] ret = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            int cur = a[i];

            while(!stk.isEmpty() && a[stk.peek()] < cur) {
                int idx = stk.pop();
                ret[idx] = cur;
            }

            stk.push(i);
        }

        while(!stk.isEmpty()) {
            ret[stk.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(ret[i]).append(" ");
        }

        System.out.println(sb);
    }
}
