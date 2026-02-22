package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String[] arr = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < s.length(); i++) {
            System.out.println(arr[i]);
        }
    }

}
