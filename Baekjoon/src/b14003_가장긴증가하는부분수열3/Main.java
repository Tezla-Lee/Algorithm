package b14003_가장긴증가하는부분수열3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] numbers;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = getStartIndex();
        int number = numbers[startIndex];

    }

    static int getStartIndex() {
        dp = new long[n][n];
        int[][] last = new int[n][n];
        StringBuilder[] progressions = new StringBuilder[n];

        int startIndex = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i][i] = numbers[i];
            last[i][i] = numbers[i];
            StringBuilder sb = new StringBuilder();
            sb.append(numbers[i]).append(" ");
            progressions[i] = sb;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(dp[j + 1][i], last[j][i - 1] < numbers[i] ? dp[j][i - 1] + numbers[i] : Math.max(dp[j][i - 1], dp[j - 1][i]));

                if (dp[j][i] > max) {
                    max = dp[j][i];
                    startIndex = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", dp[i][j]);
            }
            System.out.println();
        }

        return startIndex;
    }
}