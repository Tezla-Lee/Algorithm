package b10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][12];
        for (int i = 2; i < 11; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < 11; j++) {
                dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        long sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += dp[n][i] % 1000000000;
        }
        System.out.println(sum % 1000000000);
    }
}