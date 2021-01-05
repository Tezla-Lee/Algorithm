package b1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node>[] costs = new ArrayList[n + 1];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = new ArrayList<>();
        }
        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costs[departure].add(new Node(arrival, cost));
        }

        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(costs, departure, arrival));
    }

    static int dijkstra(ArrayList<Node>[] costs, int departure, int arrival) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(departure, 0));

        int[] minCost = new int[costs.length];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[departure] = 0;


        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node node : costs[temp.index]) {
                if (minCost[node.index] > minCost[temp.index] + node.cost) {
                    minCost[node.index] = minCost[temp.index] + node.cost;
                    queue.add(node);
                }
            }
        }

        return minCost[arrival];
    }
}

class Node implements Comparable<Node>{
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