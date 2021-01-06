package b11779_최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        lists = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int departure = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists[arrival].add(new Node(departure, cost));
        }

        st = new StringTokenizer(br.readLine());

        int arrival = Integer.parseInt(st.nextToken());
        int departure = Integer.parseInt(st.nextToken());

        dijkstra(arrival, departure);
    }

    static List<Node>[] lists;

    static void dijkstra(int arrival, int departure) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(arrival, 0));

        ArrayList<Integer>[] routes = new ArrayList[lists.length];
        int[] costs = new int[lists.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[arrival] = 0;

        for (int i = 0; i < lists.length; i++) {
            routes[i] = new ArrayList<>();
        }

        routes[arrival].add(arrival);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node next : lists[curr.index]) {
                if (costs[next.index] > costs[curr.index] + next.cost) {
                    costs[next.index] = costs[curr.index] + next.cost;
                    routes[next.index] = (ArrayList<Integer>) routes[curr.index].clone();
                    routes[next.index].add(next.index);
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(costs[departure]).append("\n");
        sb.append(routes[departure].size()).append("\n");
        for (int i : routes[departure]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}