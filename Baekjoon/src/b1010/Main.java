package b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][m + 1];
            for (int j = 1; j < m + 1; j++) {
                dp[1][j] = 1;
            }
            for (int j = 2; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    dp[j][k] = dp[j][k - 1] + dp[j - 1][k - 1];
                }
            }
            long sum = 0;
            for (int j = 0; j < m + 1; j++) {
                sum += dp[n][j];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
