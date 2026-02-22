package com.fiddich.test.keundol.test14;

import java.util.*;

public class BOJ17071 {

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        if(n == m) {
            System.out.println(0);
            return;
        }

        // 수빈이 이동
        int[][] visited = new int[2][500004];
        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);

        Queue<Integer> q = new LinkedList<>();
        visited[0][n] = 0;
        q.add(n);

        int time = 0;
        while(!q.isEmpty()) {
            time++;
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int cur = q.poll();

                for(int next : new int[]{cur-1, cur+1, cur*2}) {
                    if(next < 0 || next > 500000) {
                        continue;
                    }
                    if(visited[time % 2][next] == -1) {
                        visited[time % 2][next] = time;
                        q.add(next);
                    }
                }
            }
        }


        // 동생 이동
        int sisterPos = m;
        int sisterTime = 0;

        while(sisterPos <= 500000) {
            int arrivalTime = visited[sisterTime % 2][sisterPos];

            if(arrivalTime != -1 && arrivalTime <= sisterTime) {
                System.out.println(sisterTime);
                return;
            }

            sisterTime++;
            sisterPos += sisterTime;
        }

        System.out.println(-1);
    }
}
