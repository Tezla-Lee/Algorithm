package b9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            int temp = Integer.parseInt(br.readLine());
            n[i] = temp;
            max = Math.max(max, temp);
        }
        long[] dp = new long[max + 1];
        if (max < 6) {
            dp = new long[6];
        }
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i < max + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i = 0; i < t; i++) {
            sb.append(dp[n[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
