//package com.fiddich.test.softwaremaestro.test2;
//
//import java.util.*;
//
//public class BOJ2110 {
//
//    static int n, c;
//    static int[] a;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        c = sc.nextInt();
//        a = new int[n];
//        for(int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        Arrays.sort(a);
//        System.out.println(isValid(2));
//        int ret = Integer.MIN_VALUE;
//        int l = 1;
//        int r = a[n-1];
//        while(l <= r) {
//            int mid = l + (r - l) / 2; // 가장 인접한 공유기 사이거리
//            if(isValid(mid)) {
//                ret = Math.max(ret, mid);
//                r = mid - 1;
//            }
//            else {
//                l = mid + 1;
//            }
//        }
//
//        System.out.println(ret);
//    }
//
//    static boolean isValid(int mid) { // mid이상으로 놓인 공유기의 개수확인
//        int cur = a[0];
//        int cnt = 1;
//        for(int i = 1; i < n; i++) {
//            if(a[i] - cur >= mid) {
//                cnt++;
//                cur = a[i];
//            }
//        }
//
//        if(cnt >= c) {
//
//        }
//    }
//}
