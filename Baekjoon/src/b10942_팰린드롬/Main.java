package b10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        solution(dp, nums);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solution(boolean[][] dp, int[] nums) {
        for (int i = 1; i < dp.length; i++) {
            // 길이 1
            dp[i][i] = true;
            for (int j = i - 1; j > 0; j--) {
                // 길이 2
                if (j == i - 1 && nums[i] == nums[j]) {
                    dp[j][i] = true;
                    continue;
                }
                // 길이 3 이상
                if (dp[j + 1][i - 1] && nums[j] == nums[i]) {
                    dp[j][i] = true;
                }
            }
        }
    }
}