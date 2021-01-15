package b12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
        }

        System.out.println(solution(arr, dp));
    }

    static int n;
    static int k;

    static int solution(int[][] arr, int[][] dp) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];

            if (w > k) {
                continue;
            }

            if (i == 0) {
                dp[0][w] = v;
                max = Math.max(max, v);
                continue;
            }

            for (int j = 0; j <= k; j++) {
                if (j + w <= k) {
                    dp[i][j + w] = Math.max(dp[i - 1][j + w], dp[i - 1][j] + v);
                }

                if (dp[i][j] == 0) {
//                    if (j > 0) {
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                    }
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return max;
    }
}