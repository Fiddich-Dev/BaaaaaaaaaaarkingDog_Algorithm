package com.fiddich.test.keundol.test18;

import java.util.*;

public class BOJ1700 {

    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[k];
        for(int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }

        int ret = 0;
        // 스케쥴의 인덱스를 넣는다
        List<Integer> q = new ArrayList<>();
        for(int i = 0; i < k; i++) {

            int task = a[i];
            if(isExist(q, i)) {
                continue;
            }
            if(q.size() < n) {
                q.add(i);
                continue;
            }

            Collections.sort(q, (i1, i2) -> {
                return lastIdx(i2) - lastIdx(i1);
            });
            q.set(0, i);
            ret++;
        }

        System.out.println(ret);
    }

    static int lastIdx(int now) {
        int task = a[now];
        for(int i = now+1; i < k; i++) {
            if(a[i] == task) {
                return i;
            }
        }
        return k;
    }

    static boolean isExist(List<Integer> q, int idx) {
        int task = a[idx];
        for(int i = 0; i < q.size(); i++) {
            if(a[q.get(i)] == task) {
                q.set(i, idx);
                return true;
            }
        }
        return false;
    }

}
