package b1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = 0; j < i + 1; j++) {
                if (j > 0 && j < i) {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (i == n - 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}