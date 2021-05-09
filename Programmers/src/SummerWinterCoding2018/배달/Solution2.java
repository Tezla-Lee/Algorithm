package SummerWinterCoding2018.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int solution(int N, int[][] road, int K) {
        List<List<Road>> lists = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];

            lists.get(a).add(new Road(b, time));
            lists.get(b).add(new Road(a, time));
        }

        // 다익스트라
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        Queue<Road> qu = new PriorityQueue<>((a, b) -> a.time - b.time);
        qu.offer(new Road(1, 0));

        while (!qu.isEmpty()) {
            Road curr = qu.poll();

            for (Road next : lists.get(curr.dest)) {
                if (d[next.dest] > d[curr.dest] + next.time) {
                    d[next.dest] = d[curr.dest] + next.time;
                    qu.offer(new Road(next.dest, d[next.dest]));
                }
            }
        }

        // K이하 확인
        int count = 0;

        for (int time : d) {
            if (time <= K) {
                count++;
            }
        }

        return count;
    }

    private static class Road {
        int dest;
        int time;

        public Road(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
}