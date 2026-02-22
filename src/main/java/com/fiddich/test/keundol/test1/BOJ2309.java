package com.fiddich.test.keundol.test1;

import java.util.*;

public class BOJ2309 {

    static int[] a = new int[9];
    static int sum = 0;
    static int[] ret = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            if(i == ret[0] || i == ret[1]) {
                continue;
            }
            result.add(a[i]);
        }

        Collections.sort(result);
        for(int i : result) {
            System.out.println(i);
        }

    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == 2) {
            if(sum - a[b.get(0)] - a[b.get(1)] == 100) {
                ret[0] = b.get(0);
                ret[1] = b.get(1);
            }
            return;
        }
        for(int i = start+1; i < 9; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }
}
