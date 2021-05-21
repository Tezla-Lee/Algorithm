package b1647_도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Edge>> edges;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, c));
            edges.get(b).add(new Edge(a, c));
        }

        System.out.println(getMinCost());
    }

    private static int getMinCost() {
        int maxCost = 0;
        int sumCost = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (!isVisited[curr.number]) {
                maxCost = Math.max(maxCost, curr.cost);
                sumCost += curr.cost;

                for (Edge next : edges.get(curr.number)) {
                    if (!isVisited[next.number]) {
                        pq.add(next);
                    }
                }
                isVisited[curr.number] = true;
            }
        }
        return sumCost - maxCost;
    }

    private static class Edge implements Comparable<Edge> {
        int number;
        int cost;

        public Edge(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
