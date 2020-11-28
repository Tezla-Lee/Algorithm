package b2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
        } else {
            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = 1;
            dp[1][0] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i][j] = dp[i - 2][j - 1] + dp[i - 1][j];
                }
            }
            int answer = 0;
            for (int i = 0; i <= n / 2; i++) {
                answer += dp[n][i] * Math.pow(2, (n - 2 * i) / 2);
            }
            System.out.println(answer);
        }
    }
}