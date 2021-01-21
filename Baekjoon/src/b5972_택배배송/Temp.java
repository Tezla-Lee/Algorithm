package b5972_택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 : https://www.acmicpc.net/problem/5972
 * 7% 상황에서 시간초과가 나는 문제
 * <p>
 * 우선순위 큐를 이용한 다익스트라 알고리즘
 */
public class Temp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.addEdge(u, v, w);
        }

        System.out.println(dijkstra(graph, N, 1));
    }

    private static int dijkstra(Graph graph, int N, int start) {
        int[] dis = new int[N + 1];
        //다익스트라 알고리즘의 스패닝 트리 (각 노드는 어디 노드에서 왔는지)
        //int[] parent = new int[N+1];

        Arrays.fill(dis, Integer.MAX_VALUE);


        PriorityQueue<Node> pqueue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        dis[start] = 0;
        //parent[start] = start;
        pqueue.add(new Node(start, 0));

        //E * logE + E
        while (!pqueue.isEmpty()) {
            Node current = pqueue.poll();

            for (Node nextNode : graph.sparseList.get(current.v)) {
                int newDis = current.weight + nextNode.weight;

                if (dis[nextNode.v] > newDis) {
                    dis[nextNode.v] = newDis;
                    pqueue.add(new Node(nextNode.v, newDis));
                    //스패닝 트리에 기록, v정점은 현재의 정점 u에서 왔다라는 의미
                    //parent[nextNode.v] = current.v;
                }
            }
        }

        return dis[N];
    }

    public static class Node {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public static class Graph {
        int n;
        List<List<Node>> sparseList;

        public Graph(int n) {
            this.n = n;
            this.sparseList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++)
                sparseList.add(new ArrayList<>());
        }

        /**
         * 양쪽으로 연결
         */
        public void addEdge(int u, int v, int w) {
            sparseList.get(u).add(new Node(v, w));
            sparseList.get(v).add(new Node(u, w));
        }
    }
}