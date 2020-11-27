package b9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] firstRow;
        int[] secondRow;
        int[][] dp;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            firstRow = new int[n + 1];
            secondRow = new int[n + 1];
            dp = new int[n + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                firstRow[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                secondRow[j] = Integer.parseInt(st.nextToken());
            }
            dp[1][0] = firstRow[1];
            dp[1][1] = secondRow[1];
            for (int j = 2; j < n + 1; j++) {
                dp[j][0] = Math.max(dp[j - 1][1], dp[j - 2][1]) + firstRow[j];
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 2][0]) + secondRow[j];
            }
            sb.append(Math.max(dp[n][0], dp[n][1])).append("\n");
        }
        System.out.println(sb);
    }
}
