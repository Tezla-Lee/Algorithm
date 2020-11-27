package b11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if (n < 3) {
            dp = new int[3];
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }
        System.out.println(dp[n]);
    }
}