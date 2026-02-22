package com.fiddich.test.keundol.test5;

import java.util.*;

public class BOJ11655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ret = "";
        for(char c : s.toCharArray()) {
            if(c - 'a' >= 0 && c - 'a' < 26) {
                char temp = (char) ((c - 'a' + 13) % 26 + 'a');
                ret += String.valueOf(temp);
            }
            else if(c - 'A' >= 0 && c - 'A' < 26) {
                char temp = (char) ((c - 'A' + 13) % 26 + 'A');
                ret += String.valueOf(temp);
            }
            else {
                ret += String.valueOf(c);
            }
        }

        System.out.println(ret);
    }
}
