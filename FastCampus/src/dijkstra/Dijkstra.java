package dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    public int index;
    public int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

class Dijkstra {
    static int INF = Integer.MAX_VALUE;
    static int [] dijkstra(int start, int [][][] graph) {
        int n = graph.length;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int [] distances = new int [n];
        for (int i = 0; i < n; i++) {
            distances[i] = INF;
        }

        distances[start] = 0;

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int[] arr : graph[node.index]) {
                if (distances[arr[0]] > distances[node.index] + arr[1]) {
                    distances[arr[0]] = distances[node.index] + arr[1];
                    pq.add(new Node(arr[0], distances[arr[0]]));
                }
            }
        }

        return distances;
    }
}

class DijkstraTest {
    public static void main(String[] args) {
        int start = 0;
        int [][][] graph = {
                {{2, 5}, {3, 2}}, // 0번 노드의 {인접 노드, 가중치}
                {{3, 5}, {4, 3}}, // 1번 노드의 {인접 노드, 가중치}
                {{0, 3}, {4, 9}}, // ...
                {{0, 10}, {4, 2}},
                {{2, 13}, {1, 3}}
        };

        int [] distances = Dijkstra.dijkstra(start, graph);
        System.out.println(Arrays.toString(distances));
    }
}
