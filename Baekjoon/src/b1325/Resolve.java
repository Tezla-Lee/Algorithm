package b1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Resolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        computers = new ArrayList[n + 1];
        count = new int[n + 1];
        dp = new int[n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int comA = Integer.parseInt(st.nextToken());
            int comB = Integer.parseInt(st.nextToken());
            computers[comA].add(comB);
        }
        for (int i = 1; i <= n; i++) {
            isVisited = new boolean[n + 1];
            bfs(i);
        }

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, dp[i]);
        }

        for (int i = 1; i < n + 1; i++) {
            if (dp[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static int[] count;
    static int[] dp;
    static ArrayList<Integer>[] computers;
    static boolean[] isVisited;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            dp[temp]++;
            for (int k : computers[temp]) {
                if (!isVisited[k]) {
                    isVisited[k] = true;
                    queue.add(k);
                }
            }
        }
    }
}