package _2021_카인.프로그래밍4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    private ArrayList<ArrayList<Node>> edges;
    private ArrayList<ArrayList<Node>> reverseEdges;
    private Set<Integer> trapSet;
    private int min;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        edges = new ArrayList<>();
        reverseEdges = new ArrayList<>();
        trapSet = new HashSet<>();
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
            reverseEdges.add(new ArrayList<>());
        }

        for (int trap : traps) {
            trapSet.add(trap);
        }

        for (int[] road : roads) {
            edges.get(road[0]).add(new Node(road[1], road[2], trapSet.contains(road[0])));
            reverseEdges.get(road[1]).add(new Node(road[0], road[2], trapSet.contains(road[1])));
        }

        return dijkstra(start, end);
    }

    private int dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(start, 0, false));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.number == end) {
                return curr.distance;
            }

            ArrayList<Node> nodes;

            if (curr.isReversed) {
                nodes = reverseEdges.get(curr.number);
            } else {
                nodes = edges.get(curr.number);
            }

            for (Node node : nodes) {
                int distance = curr.distance + node.distance;
                boolean isReverse = false;

                if (trapSet.contains(node.number)) {
                    isReverse = !node.isReversed;
                }

                queue.offer(new Node(node.number, distance, isReverse));
            }
        }

        return min;
    }

    private static class Node implements Comparable<Node> {
        int number;
        int distance;
        boolean isReversed;

        public Node(int number, int distance, boolean isReversed) {
            this.number = number;
            this.distance = distance;
            this.isReversed = isReversed;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println("----------------------------");
        System.out.println(new Solution2().solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }
}