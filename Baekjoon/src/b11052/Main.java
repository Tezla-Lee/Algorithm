package b11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(dp[i - j] + dp[j], max);
            }
            dp[i] = Math.max(max, price[i]);
        }
        System.out.println(dp[n]);
    }
}
