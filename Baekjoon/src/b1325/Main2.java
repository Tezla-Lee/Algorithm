package b1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        network = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            network[i] = new ArrayList<>();
        }
        dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
        }
        for (int i = 1; i < n + 1; i++) {
            isV = new boolean[n + 1];
            bfs(i);
//            dfs(i);
//            System.out.println();
        }
//        System.out.println(Arrays.toString(dp));
        int max = Integer.MIN_VALUE;
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

    static ArrayList<Integer>[] network;
    static int[] dp;
    static boolean[] isV;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isV[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
//            System.out.print(temp + " ");
            dp[temp]++;
            for (int i : network[temp]) {
                if (!isV[i]) {
                    isV[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    static int count;

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        isV[start] = true;
        stack.add(start);

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            dp[temp]++;
            for (int i : network[temp]) {
                if (!isV[i]) {
                    isV[i] = true;
                    stack.add(i);
                }
            }
        }
    }
}
