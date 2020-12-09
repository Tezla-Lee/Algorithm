package b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int caseNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        board = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            board[i] = new ArrayList<>();
        }
        route = new int[n + 1];
        Arrays.fill(route, INF);
        check = new boolean[n + 1];
        int a, b, c;
        for (int i = 0; i < caseNum; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            board[a].add(new Node(b, c));
        }
        bfs(start);
        for (int i = 1; i < n + 1; i++) {
            if (route[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(route[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] board;
    static int[] route;
    static int n;
    static boolean[] check;

    static void bfs(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        route[start] = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (check[temp.index]) {
                continue;
            }
            int t = temp.index;
            check[t] = true;
            for (Node node : board[t]) {
                if (route[node.index] > route[t] + node.distance) {
                    route[node.index] = route[t] + node.distance;
                    queue.add(new Node(node.index, route[node.index]));
                }
            }
        }
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