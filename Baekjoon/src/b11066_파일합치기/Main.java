package b11066_파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] files = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            for (int j = 1; j < n + 1; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void merge(int[][] dp, int[] files) {
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int i = 0; i < dp.length; i++) {

        }
    }
}