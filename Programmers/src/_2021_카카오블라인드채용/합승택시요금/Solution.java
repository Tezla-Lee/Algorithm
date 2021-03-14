package _2021_카카오블라인드채용.합승택시요금;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] info : fares) {
            list.get(info[0]).add(new Price(info[1], info[2]));
            list.get(info[1]).add(new Price(info[0], info[2]));
        }

        sCosts = new int[n + 1];
        aCosts = new int[n + 1];
        bCosts = new int[n + 1];

        findMinCost(sCosts, s);
        findMinCost(aCosts, a);
        findMinCost(bCosts, b);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, sCosts[i] + aCosts[i] + bCosts[i]);
        }

        return answer;
    }

    static int[] sCosts;
    static int[] aCosts;
    static int[] bCosts;
    static List<List<Price>> list;

    static void findMinCost(int[] costs, int start) {
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Node(0, start));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Price price : list.get(curr.number)) {
                if (costs[price.dest] > price.cost + costs[curr.number]) {
                    costs[price.dest] = price.cost + costs[curr.number];
                    pq.offer(new Node(costs[price.dest], price.dest));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, 4, 6, 2, new int[][]{{4, 1, 10},{3, 5, 24},{5, 6, 2},{3, 1, 41},
        {5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}}));
    }
}

class Node {
    int cost;
    int number;

    public Node(int cost, int number) {
        this.cost = cost;
        this.number = number;
    }
}

class Price {
    int dest;
    int cost;

    public Price(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}