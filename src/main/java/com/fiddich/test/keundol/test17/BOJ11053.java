package com.fiddich.test.keundol.test17;

import java.util.*;

public class BOJ11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            int pos = lowerBound(ret, num);
            if(pos == ret.size()) {
                ret.add(num);
                continue;
            }
            ret.set(pos, num);
        }

        System.out.println(ret.size());
    }

    static int lowerBound(List<Integer> ret, int num) {
        int l = 0;
        int r = ret.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(ret.get(mid) >= num) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}
