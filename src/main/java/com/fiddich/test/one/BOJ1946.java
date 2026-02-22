package com.fiddich.test.one;

import java.util.*;
import java.io.*;

public class BOJ1946 {

    public static void main(String[] args) throws IOException {

        int[] q = {5, 1, 3, 2, 4};
        System.out.println(solve(q));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        while(t-- != 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Pair[] a = new Pair[n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                a[i] = new Pair(temp1, temp2);
            }

            Arrays.sort(a, (p1, p2) -> {
                if(p2.a == p1.a) {
                    return p1.b - p2.b;
                }
                return p2.a - p1.a;
            });

            int[] temp = new int[n];
            for(int i = 0; i < n; i++) {
                temp[i] = a[i].b;
            }
            sb.append(solve(temp)).append("\n");
        }
        System.out.println(sb);
    }

    static int lis(int[] a) {
        int n = a.length;
        int[] temp = new int[n];
        int cursor = 0;
        for(int i = 0; i < n; i++) {
            int pos = binarySearch(temp, a[i], cursor);
            if(pos == cursor) {
                cursor++;
            }
            temp[pos] = a[i];
        }

        return cursor;
    }

    static int binarySearch(int[] a, int target, int max) {
        int l = 0;
        int r = max;
        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }

    static int solve(int[] a) {
        int n = a.length;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            int cur = a[i];

            while(!stk.isEmpty()) {
                int prev = stk.peek();
                if(prev > cur) {
                    stk.pop();
                    continue;
                }
                break;
            }

            stk.add(cur);
        }

        return stk.size();
    }

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
