package b1238_파티;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> arrayList = new ArrayList<>();
        int[][] d = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arrayList.get(start).add(new Node(end, time));
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dijkstra(arrayList, i, d);
        }

        for (int i = 1; i <= n ; i++) {
            max = Math.max(max, d[i][x] + d[x][i]);
        }

        System.out.println(max);
    }

    static void dijkstra(ArrayList<ArrayList<Node>> arrayList, int arrival, int[][] d) {
        d[arrival][arrival] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(arrival, 0));

        while (!queue.isEmpty()) {
            Node start = queue.poll();
            for (Node end : arrayList.get(start.departure)) {
                if (d[arrival][end.departure] > d[arrival][start.departure] + end.time) {
                    d[arrival][end.departure] = d[arrival][start.departure] + end.time;
                    queue.add(end);
                }
            }
        }
    }
}
class Node implements Comparable<Node> {
    int departure;
    int time;

    public Node(int index, int time) {
        this.departure = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return time - o.time;
    }
}