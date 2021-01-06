package b1504_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE / 3; // Integer.MAX_VALUE 로 하면 overflow 됨.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] lists = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int min = Math.min(dijkstra(lists, 1, v1) + dijkstra(lists, v1, v2) + dijkstra(lists, v2, n), dijkstra(lists, 1, v2) + dijkstra(lists, v2, v1) + dijkstra(lists, v1, n));

        if (min >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static int dijkstra(ArrayList<Node>[] lists, int arrival, int departure) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(arrival, 0));

        int[] d = new int[lists.length];
        Arrays.fill(d, INF);
        d[arrival] = 0;

        while (!queue.isEmpty()) {
            Node prev = queue.poll();
            for (Node curr : lists[prev.index]) {
                if (d[curr.index] > d[prev.index] + curr.distance) {
                    d[curr.index] = d[prev.index] + curr.distance;
                    queue.add(curr);
                }
            }
        }
        return d[departure];
    }
}

class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}