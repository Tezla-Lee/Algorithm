package b11066_파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            long[][] dp = new long[k][k];
            int[] files = new int[k];
            s = new int[k];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                files[j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    s[j] = files[0];
                    continue;
                }
                s[j] = s[j - 1] + files[j];
            }

            sb.append(searchMinCost(dp, files)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int[] s;

    static int sum(int start, int end) {
        if (start == 0) {
            return s[end];
        }

        return s[end] - s[start - 1];
    }

    static long searchMinCost(long[][] dp, int[] files) {
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int gap = 2; gap < dp.length; gap++) {    //i와 j간 gap 3칸부터
            for (int i = 0; i + gap < dp.length; i++) {    //i인덱스
                int j = i + gap;    //j인덱스
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {   //i~j 사이의 k값
                    dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + sum(i, j), dp[i][j]);
                }
            }
        }

        return dp[0][dp.length - 1];
    }
}