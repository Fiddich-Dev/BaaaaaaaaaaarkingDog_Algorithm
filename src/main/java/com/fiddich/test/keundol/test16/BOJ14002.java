package com.fiddich.test.keundol.test16;

import java.util.*;

public class BOJ14002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int start = 0;
        int ret = 1;
        int[] prev = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        Arrays.fill(prev, -1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j] && cnt[i] < cnt[j] + 1) {
                    cnt[i] = cnt[j] + 1;
                    prev[i] = j;

                }
            }

            if(ret < cnt[i]) {
                ret = cnt[i];
                start = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while(start != -1) {
            result.add(a[start]);
            start = prev[start];
        }

        Collections.reverse(result);
        System.out.println(ret);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
