package b11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][1] = numbers[1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (numbers[j] > numbers[i]) {
                    dp[i][j] = Math.max(dp[i][i] + numbers[j], dp[i - 1][j]);
                } else {
                    if (dp[i][j] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], numbers[j]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}