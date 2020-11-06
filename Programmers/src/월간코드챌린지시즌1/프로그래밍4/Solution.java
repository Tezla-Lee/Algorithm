package 월간코드챌린지시즌1.프로그래밍4;


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    static ArrayList<PriorityQueue<Integer>> arr;

    public int solution(int[][] t) {
        int answer = 0;
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
        for (int i = 0; i < max; i++) {
            check.add(i);
            check.add(i);
        }
        arr = new ArrayList<>();
        for (int i = 0; i < max + 1; i++) {
            arr.add(new PriorityQueue<>());
        }
        for (int[] a : t) {
            arr.get(a[0]).add(a[1]);
            arr.get(a[1]).add(a[0]);
        }
        for (PriorityQueue<Integer> a : arr) {
            System.out.println(a);
        }
        dfs(0, arr, 0, check);
        return answer;
    }

    static ArrayList<Integer> check = new ArrayList<>();

    static void dfs(int start, ArrayList<PriorityQueue<Integer>> go, int depth, ArrayList<Integer> ch) {
        ArrayList<Integer> check2 = check;
        ArrayList<PriorityQueue<Integer>> go2 = go;
        if (go2.get(start).isEmpty()) {
//            System.out.println(depth);
            System.out.println("RM");
            return;
        }
        while (!go2.get(start).isEmpty()) {
            int temp = go2.get(start).poll();
            System.out.println(temp);
            if (check.contains(temp)) {
                dfs(temp, go2, depth + 1, check2);
            }
        }
    }

//    public static void main(String[] args) {
//        new Solution().solution(new int[][]{{5, 1}, {2, 5}, {3, 5}, {3, 6}, {2, 4}, {4, 0}});
//    }
}
