package b2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        int[] point = new int[n + 1];
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }
        dp[1][0] = dp[1][1] = point[1];
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][1] + point[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + point[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
