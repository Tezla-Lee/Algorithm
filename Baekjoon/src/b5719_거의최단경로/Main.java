package b5719_거의최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 장소 수
            int m = Integer.parseInt(st.nextToken()); // 도로 수

            if (n == 0 && m == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int d = Integer.parseInt(st.nextToken()); // 도착점

            edges = new int[n][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                edges[u][v] = p;
            }

            int shortestDistance = SearchBestDistance(n, s, d);

            if (shortestDistance == Integer.MAX_VALUE) {
                sb.append("-1").append("\n");
                continue;
            }

            // 최단 거리 경로 삭제
            deleteBestRoute(d);

            int distance = SearchBestDistance(n, s, d);

            if (distance == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                sb.append(distance);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static int[][] edges;
    static int[] d; // 각 노드까지의 최단 거리

    static int SearchBestDistance(int n, int start, int destination) {
        d = new int[n];

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[current.number][i] != 0 && d[i] > current.distance + edges[current.number][i]) {
                    d[i] = current.distance + edges[current.number][i];
                    queue.add(new Node(i, d[i]));
                }
            }
        }

        return d[destination];
    }

    // 도착점부터 역으로 가면서 삭제
    static void deleteBestRoute(int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < edges.length; i++) {
                if (edges[i][temp] != 0 && d[temp] - edges[i][temp] == d[i]) {
                    queue.add(i);
                    edges[i][temp] = 0;
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int number;
    int distance;

    public Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}