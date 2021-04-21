package 연습문제.탐욕법.섬_연결하기;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    List<List<Node>> lists;
    boolean[] isVisited;

    public int solution(int n, int[][] costs) {
        lists = new ArrayList<>();
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] info : costs) {
            int num1 = info[0];
            int num2 = info[1];
            int cost = info[2];

            lists.get(num1).add(new Node(num2, cost));
            lists.get(num2).add(new Node(num1, cost));
        }

        return visit();
    }

    int visit() {
        int totalCost = 0;
        Queue<Node> pq = new PriorityQueue<>(); // 가까운 노드들부터 방문하기 위해

        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (!isVisited[curr.num]) {
                totalCost += curr.cost;

                for (Node next : lists.get(curr.num)) {
                    if (!isVisited[next.num]) {
                        pq.offer(next);
                    }
                }

                isVisited[curr.num] = true;
            }
        }

        return totalCost;
    }
}

class Node implements Comparable<Node> {
    int num;
    int cost;

    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}