package b2618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        int[] police1 = new int[2];
        int[] police2 = new int[2];
        int[][] map = new int[w + 1][w + 1];
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Math.abs(police1[0] - row) + Math.abs(police1[1] - col);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Math.abs(police2[0] - row) + Math.abs(police2[1] - col);
        }
        System.out.println(Arrays.deepToString(dp));
    }
}
