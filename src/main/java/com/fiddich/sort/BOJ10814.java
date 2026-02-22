package com.fiddich.sort;

import java.io.*;
import java.util.*;

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Person[] ret = new Person[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            ret[i] = new Person(i, age, name);
        }

        Arrays.sort(ret, (p1, p2) -> {
            if(p1.age == p2.age) {
                return p1.order - p2.order;
            }
            return p1.age - p2.age;
        });

        for(Person p : ret) {
            System.out.println(p.age + " " + p.name);
        }
    }

    static class Person {
        int order;
        int age;
        String name;

        public Person(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
}
