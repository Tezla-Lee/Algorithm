package b13398_연속합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n + 1];
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = numbers[1];
        int max = dp[1][0];

        for (int i = 2; i < n + 1; i++) {
            if (numbers[i] < 0) {
                dp[i][0] = Math.max(dp[i - 1][0] + numbers[i], dp[i - 1][0] + dp[i - 1][1]);
                dp[i][1] = Math.min(numbers[i], dp[i - 1][1]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0] + numbers[i], numbers[i]);
                dp[i][1] = dp[i - 1][1];
            }
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.printf("%4d", dp[i][0]);
        }
        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            System.out.printf("%4d", dp[i][1]);
        }
        System.out.println();

        System.out.println(max);
    }
}