package com.fiddich.test.keundol.test22;

import java.util.*;

public class BOJ1269 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int target = a[i];
            int l = 0;
            int r = b.length - 1;

            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(b[mid] == target) {
                    cnt++;
                    break;
                }
                else if(b[mid] > target) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }

        System.out.println(n + m - 2*cnt);
    }
}
