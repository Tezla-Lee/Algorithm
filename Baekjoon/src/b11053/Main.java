package b11053;

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
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}