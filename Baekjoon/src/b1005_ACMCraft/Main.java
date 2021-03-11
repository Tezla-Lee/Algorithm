package b1005_ACMCraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] times = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(y).add(x);
            }

            int w = Integer.parseInt(br.readLine());

            sb.append(dp(w, times[w], times)).append("\n");
        }
        System.out.println(sb);
    }

    static List<List<Integer>> list;

    static int dp(int num, int time, int[] times) {
        int[] dp = new int[list.size()];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[num] = time;
        int max = time;

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(num);

        while (!qu.isEmpty()) {
            int building = qu.poll();

            for (int n : list.get(building)) {
                if (dp[n] < times[n] + dp[building]) {
                    dp[n] = times[n] + dp[building];
                    max = Math.max(max, dp[n]);
                    qu.offer(n);
                }
            }
        }

        return max;
    }
}
