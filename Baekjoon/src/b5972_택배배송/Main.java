package b5972_택배배송;

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

        edges = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new Node(b, c));
            edges[b].add(new Node(a, c));
        }

        System.out.println(findMinimalFeed(n));
    }

    static ArrayList<Node>[] edges;

    static int findMinimalFeed(int destination) {
        int[] feeds = new int[destination + 1];

        Arrays.fill(feeds, Integer.MAX_VALUE);
        feeds[1] = 0;

        Queue<Node> priorityQueue = new PriorityQueue<>((a, b) -> a.feed - b.feed);
        priorityQueue.add(new Node(1, 0));

        while (!priorityQueue.isEmpty()) {
            Node temp = priorityQueue.poll();

            for (Node node : edges[temp.number]) {
                if (feeds[node.number] > feeds[temp.number] + node.feed) {
                    feeds[node.number] = feeds[temp.number] + node.feed;
                    priorityQueue.add(new Node(node.number, feeds[node.number]));
                }
            }
        }

        return feeds[destination];
    }
}

class Node {
    int number;
    int feed;

    public Node(int number, int feed) {
        this.number = number;
        this.feed = feed;
    }
}