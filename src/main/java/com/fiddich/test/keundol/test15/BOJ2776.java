package com.fiddich.test.keundol.test15;

import java.util.*;

public class BOJ2776 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int m = sc.nextInt();
            for(int i = 0; i < m; i++) {
                int num = sc.nextInt();
                sb.append(binarySearch(a, num)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] a, int num) {
        int l = 0;
        int r = a.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(a[mid] == num) {
                return 1;
            }
            else if(a[mid] > num) {
                r = mid - 1;
            }
            else if(a[mid] < num) {
                l = mid + 1;
            }
        }
        return 0;
    }
}
