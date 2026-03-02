package com.fiddich.test.keundol.test23;

import java.util.*;

public class BOJ11723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int ret = 0;
        for(int i = 0; i < n; i++) {
            String command = sc.next();
            if(command.equals("add")) {
                int num = sc.nextInt();
                ret |= (1 << num);
            }
            else if(command.equals("remove")) {
                int num = sc.nextInt();
                ret &= ~(1 << num);
            }
            else if(command.equals("check")) {
                int num = sc.nextInt();
                if((ret & (1 << num)) != 0) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if(command.equals("toggle")) {
                int num = sc.nextInt();
                ret ^= (1 << num);
            }
            else if(command.equals("all")) {
                ret = (1 << 22) - 1;
            }
            else if(command.equals("empty")) {
                ret = 0;
            }
        }

        System.out.println(sb);
    }
}
//add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//all: S를 {1, 2, ..., 20} 으로 바꾼다.
//empty: S를 공집합으로 바꾼다.
