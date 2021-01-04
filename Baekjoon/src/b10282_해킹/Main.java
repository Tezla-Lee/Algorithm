package b10282_해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] computers = new int[n + 1][n + 1];
            int[] time = new int[n + 1];

            Arrays.fill(time, INF);

            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j == k) {
                        continue;
                    }
                    computers[j][k] = INF;
                }
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                computers[b][a] = s;
            }

            dijkstra(computers, c, time);

            System.out.println();
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (computers[j][k] == INF) {
                        System.out.print("INF ");
                    } else {
                        System.out.printf("%3d ", computers[j][k]);
                    }
                }
                System.out.println();
            }
        }

    }

    static void dijkstra(int[][] arr, int start, int[] d) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time - o2.time;
            }
        });
        queue.offer(new Node(start, 0));

        boolean[][] isVisited = new boolean[arr.length][arr.length];

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < arr.length; i++) {
//                if (d[]) {
//                    isVisited[start][i] = true;
//                    queue.add(new Node(i, arr[start][i]));
//                }
            }
        }
    }
}

class Node {
    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}