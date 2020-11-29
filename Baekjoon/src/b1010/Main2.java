package b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        int[][] info = new int[testNum][2];
        int nMax = 0;
        int mMax = 0;
        for (int i = 0; i < testNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            nMax = Math.max(nMax, n);
            mMax = Math.max(mMax, m);
            info[i][0] = n;
            info[i][1] = m;
        }
        long[][] dp = new long[nMax + 1][mMax + 1];
        for (int i = 1; i < mMax + 1; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < nMax + 1; i++) {
            for (int j = 1; j < mMax + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        for (int i = 0; i < testNum; i++) {
            long sum = 0;
            for (int j = 0; j < info[i][1] + 1; j++) {
                sum += dp[info[i][0]][j];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}