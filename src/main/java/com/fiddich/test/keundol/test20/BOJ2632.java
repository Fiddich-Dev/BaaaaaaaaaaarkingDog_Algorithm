package com.fiddich.test.keundol.test20;

import java.util.*;

public class BOJ2632 {

    static int n, cntA, cntB;
    static int[] a, b, psumA, psumB;

    static List<Integer> aa = new ArrayList<>();
    static List<Integer> bb = new ArrayList<>();

    public static void main(String[] args) {
        makeArr();

        Collections.sort(aa);
        Collections.sort(bb);

//        for(int i : aa) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for(int i : bb) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int ret = 0;
        for(int i = 0; i < aa.size(); i++) {
            int target = n - aa.get(i);
            // target보다 처음 커지는 인덱스 - target이 처음 등장하는 인덱스
            int lastIdx = upperBound(target);
            int firstIdx = lowerBound(target);
            ret += lastIdx - firstIdx;
        }

        System.out.println(ret);
    }

    static void makeArr() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cntA = sc.nextInt();
        cntB = sc.nextInt();
        a = new int[cntA * 2];
        b = new int[cntB * 2];
        psumA = new int[cntA * 2 + 1];
        psumB = new int[cntB * 2 + 1];
        for(int i = 0; i < cntA; i++) {
            a[i] = sc.nextInt();
            a[i+cntA] = a[i];
        }
        for(int i = 0; i < cntB; i++) {
            b[i] = sc.nextInt();
            b[i+cntB] = b[i];
        }

        for(int i = 1; i <= cntA * 2; i++) {
            psumA[i] = psumA[i-1] + a[i-1];
        }
        for(int i = 1; i <= cntB * 2; i++) {
            psumB[i] = psumB[i-1] + b[i-1];
        }

        for(int i = 1; i < cntA; i++) { // 길이
            for(int j = 1; j <= cntA; j++) {
                aa.add(psumA[j + i - 1] - psumA[j - 1]);
            }
        }
        for(int i = 1; i < cntB; i++) { // 길이
            for(int j = 1; j <= cntB; j++) {
                bb.add(psumB[j + i - 1] - psumB[j - 1]);
            }
        }

        aa.add(0);
        aa.add(psumA[cntA]);
        bb.add(0);
        bb.add(psumB[cntB]);
    }

    static int lowerBound(int target) {
        int l = 0;
        int r = bb.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(bb.get(mid) >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }

    static int upperBound(int target) {
        int l = 0;
        int r = bb.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(bb.get(mid) > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
