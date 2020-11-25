package b9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] numbers = new int[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            max = Math.max(n, max);
            numbers[i] = n;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int j = 4; j < max + 1; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        for (int i = 0; i < t; i++) {
            sb.append(dp[numbers[i]]).append("\n");
        }
        System.out.println(sb);
    }
}