package 월간코드챌린지시즌1.프로그래밍4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {
    public int solution(int[][] t) {
        ArrayList<PriorityQueue<Integer>> arr = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int[] a : t) {
            for (int b : a) {
                priorityQueue.add(b);
            }
        }
        int max = priorityQueue.peek();
//        for (int i = 0; i < max + 1; i++) {
//            arr.add(new PriorityQueue<>());
//        }

        int[][] computers = new int[max + 1][max + 1];
        for (int[] a : t) {
            computers[a[0]][a[1]] = 1;
            computers[a[1]][a[0]] = 1;
        }
        for (int i = 0; i < computers.length; i++) {
            computers[i][i] = 1;
        }

//        for (int[] a : computers) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int answer = 0;
        int[] visited = new int[max + 1];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != 2) {
                answer += dfs(i, computers, visited);
            }
        }
        return answer;
    }

    public int dfs(int n, int[][] computers, int[] visited) {
        if (visited[n] != 2) {
            return 0;
        }
        visited[n]++;

        for (int i = 0; i < computers[n].length; i++) {
            if (computers[n][i] == 1) {
                dfs(i, computers, visited);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().solution(new int[][]{{2, 5}, {2, 0}, {3, 2}, {4, 2}, {2, 1}}));
    }
}
