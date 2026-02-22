package com.fiddich.test.one;

import java.util.*;

public class BOJ17266 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for(int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        List<Integer> arr = new ArrayList<>();
        arr.add(a[0]);
        arr.add(n - a[m-1]);
        for(int i = 0; i < m-1; i++) {
            int l = (a[i+1] - a[i]) / 2;
            if((a[i+1] - a[i]) % 2 == 1) {
                l++;
            }
            arr.add(l);
        }

        Collections.sort(arr, Collections.reverseOrder());

        System.out.println(arr.get(0));
    }
}
