package com.fiddich.test.keundol.test11;

import java.util.*;
import java.io.*;

public class BOJ3474 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        while(t-- != 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            long a = 2;
            long b = 5;

            long cnt2 = 0;
            long cnt5 = 0;

            while(a <= n || b <= n) {
                if(a <= n) {
                    cnt2 += n / a;
                    a *= 2;
                }

                if(b <= n) {
                    cnt5 += n / b;
                    b *= 5;
                }
            }

//            System.out.println(a + " : " + b);
            sb.append(Math.min(cnt2, cnt5)).append("\n");
        }
        System.out.println(sb);
    }

}
