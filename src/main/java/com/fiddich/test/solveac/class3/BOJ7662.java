package com.fiddich.test.solveac.class3;

import java.util.*;
import java.io.*;

public class BOJ7662 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while(t-- != 0) {
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();
            PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(cmd == 'I') {
                    pqMin.add(num);
                    pqMax.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else if(cmd == 'D') {
                    if(num == 1) { // 최댓값 삭제
                        while(!pqMax.isEmpty()) {
                            int max = pqMax.poll();
                            if(map.get(max) > 0) {
                                map.put(max, map.get(max) - 1);
                                break;
                            }
                        }
                    }
                    else if(num == -1) {
                        while(!pqMin.isEmpty()) {
                            int min = pqMin.poll();
                            if(map.get(min) > 0) {
                                map.put(min, map.get(min) - 1);
                                break;
                            }
                        }
                    }
                }
            }

            solve(pqMin, pqMax, map);
        }
    }

    static void solve(PriorityQueue<Integer> pqMin, PriorityQueue<Integer> pqMax, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()) {
            for(int i = 0; i < map.get(key); i++) {
                list.add(key);
            }
        }

        Collections.sort(list);

//        for(int i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        if(list.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            System.out.println(list.get(list.size() - 1) + " " + list.get(0));
        }
    }
}
