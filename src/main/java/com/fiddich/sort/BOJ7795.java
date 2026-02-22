package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ7795 {

    static int[] a;
    static int[] b;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int ret = 0;
            int cur = 0;
            for(int i = 0; i < n; i++) {
                int r = a[i];
                while(true) {
                    if(cur == m) {
                        break;
                    }
                    int target = b[cur];
                    if(r <= target) {
                        break;
                    }
                    cur++;
                }
                System.out.println(cur);
                ret += cur;
            }

            System.out.println(ret);
        }
    }

    // target 보다 처음 크거나 같은 위치 찾기
    static int lowerBound(int target) {
        int l = 0;
        int r = m;

        while(l < r) {
            int mid = (l + r) / 2;
            if(b[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
