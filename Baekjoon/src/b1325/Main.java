package b1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        network = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[b][a] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i]) {
                count = 0;
                dfs(i);
                System.out.println();
                dp[i] = count;
                max = Math.max(count, max);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (dp[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int[][] network;
    static boolean[] isVisited;
    static int[] dp;
    static int count;

    static void dfs(int start) {
        isVisited[start] = true;
        System.out.print(start + " ");
        count++;
        for (int i = 1; i < dp.length; i++) {
            if (network[start][i] == 1) {
                if (dp[i] != 0) {
                    count += dp[i];
                    continue;
                }
                dfs(i);
            }
        }
    }
}