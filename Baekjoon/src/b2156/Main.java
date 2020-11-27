package b2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        int[] wine = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[1][0] = dp[1][1] = wine[1];
        for (int i = 2; i < n + 1; i++) {
            if (wine[i] == 0) {
                dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 2][0]), Math.max(dp[i - 1][1], dp[i - 2][1]));
                dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i - 2][0]), Math.max(dp[i - 1][1], dp[i - 2][1]));
            } else if (wine[i - 2] == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + wine[i];
                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + wine[i];
            } else {
                dp[i][0] = dp[i - 1][1] + wine[i];
                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + wine[i];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), Math.max(dp[n - 1][0], dp[n - 1][1])));
    }
}