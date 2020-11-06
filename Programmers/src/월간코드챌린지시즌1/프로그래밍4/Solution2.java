package 월간코드챌린지시즌1.프로그래밍4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int solution(int[][] t) {
        int answer = 0;
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
        for (int i = 0; i < max + 1; i++) {
            arr.add(new PriorityQueue<>());
        }
        for (int[] a : t) {
            arr.get(a[0]).add(a[1]);
            arr.get(a[1]).add(a[0]);
        }
        for (PriorityQueue<Integer> ab : arr) {
            System.out.print(ab + " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution2().solution(new int[][]{{5, 1}, {2, 5}, {3, 5}, {3, 6}, {2, 4}, {4, 0}});
        System.out.println();
        new Solution2().solution(new int[][]{{2, 5}, {2, 0}, {3, 2}, {4, 2}, {2, 1}});
    }
}
