package com.fiddich.test.keundol.test25;

import java.util.*;

public class BOJ14003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] idxLog = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List<Integer> lis = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int target = a[i];
            int pos = lowerBound(lis, target);
            if(pos == lis.size()) {
                lis.add(target);
            }
            else {
                lis.set(pos, target);
            }
            idxLog[i] = pos;
        }

        System.out.println(lis.size());

        List<Integer> ret = new ArrayList<>();
        int findIdx = lis.size() - 1;
        for(int i = n-1; i >= 0; i--) {
            if(idxLog[i] == findIdx) {
                ret.add(a[i]);
                findIdx--;
            }
        }

        Collections.reverse(ret);

        for(int i : ret) {
            System.out.print(i + " ");
        }
    }

    static int lowerBound(List<Integer> lis, int target) {
        int l = 0;
        int r = lis.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(lis.get(mid) >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
