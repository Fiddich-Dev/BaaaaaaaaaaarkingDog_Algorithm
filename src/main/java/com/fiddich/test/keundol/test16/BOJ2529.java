package com.fiddich.test.keundol.test16;

import java.util.*;

public class BOJ2529 {
    static int n;
    static char[] a;

    static String ret1 = "";
    static String ret2 = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new char[n];
        for(int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            a[i] = c;
        }

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        go(0, new int[n+1], new int[10]);

        System.out.println(ret2);
        System.out.println(ret1);
    }

    static boolean isValid(int[] arr, char[] a) {
        for(int i = 0; i < n; i++) {
            if(a[i] == '>') {
                if(arr[i] <= arr[i+1]) {
                    return false;
                }
            }
            else if(a[i] == '<') {
                if(arr[i] >= arr[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    static String make(int[] temp) {
        StringBuilder sb = new StringBuilder();
        for(int i : temp) {
            sb.append(i);
        }
        return sb.toString();
    }

    static void go(int now, int[] temp, int[] visited) {
        if(now == n+1) {
            if(isValid(temp, a)) {
                if(ret1.isEmpty()) {
                    ret1 = make(temp);
                }
                else {
                    ret2 = make(temp);
                }
            }
            return;
        }
        for(int i = 0; i <= 9; i++) {
            if(visited[i] == 1) {
                continue;
            }
            temp[now] = i;
            visited[i] = 1;

            go(now + 1, temp, visited);

            visited[i] = 0;
            temp[now] = 0;
        }
    }

}
