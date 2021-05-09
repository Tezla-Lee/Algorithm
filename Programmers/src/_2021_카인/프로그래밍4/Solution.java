package _2021_카인.프로그래밍4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private ArrayList<ArrayList<Node>> edges;
    private ArrayList<ArrayList<Node>> reverseEdges;
    private Set<Integer> trapSet;
    private boolean[] isReversed;
    private int[] visitCount;
    private int[] distance;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        edges = new ArrayList<>();
        reverseEdges = new ArrayList<>();
        trapSet = new HashSet<>();
        isReversed = new boolean[n + 1];
        visitCount = new int[n + 1];
        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

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
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(start, 0, false));
        distance[start] = 0;
        visitCount[start] = 1;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (trapSet.contains(curr.dest)) {
                isReversed[curr.dest] = !isReversed[curr.dest];
            }

            if (isReversed[curr.dest]) {
                for (Node node : reverseEdges.get(curr.dest)) {
                    if (visitCount[node.dest] <= 2) {
                        distance[node.dest] = distance[curr.dest] + node.distance;
                        visitCount[node.dest]++;
                        if (node.dest == end) {
                            System.out.println(Arrays.toString(distance));
                            return distance[node.dest];
                        }
                        queue.offer(node);
                    }
                }
            } else {
                for (Node node : edges.get(curr.dest)) {
                    if (visitCount[node.dest] <= 2) {
                        distance[node.dest] = distance[curr.dest] + node.distance;
                        visitCount[node.dest]++;
                        if (node.dest == end) {
                            System.out.println(Arrays.toString(distance));
                            return distance[node.dest];
                        }
                        queue.offer(node);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));

        return distance[end];
    }

    private static class Node {
        int dest;
        int distance;
        boolean isTrap;

        public Node(int end, int distance, boolean isTrap) {
            this.dest = end;
            this.distance = distance;
            this.isTrap = isTrap;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println("----------------------------");
        System.out.println(new Solution().solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }
}