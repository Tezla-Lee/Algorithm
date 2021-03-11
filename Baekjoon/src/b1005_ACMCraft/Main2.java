package b1005_ACMCraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
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

            int[] indegree = new int[n + 1];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(x).add(y);
                indegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            sb.append(dp(w, times, indegree)).append("\n");
        }

        System.out.println(sb);
    }

    static List<List<Integer>> list;

    static int dp(int w, int[] times, int[] indegree) {
        Queue<Integer> qu = new LinkedList<>();
        int[] result = times.clone();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            int curr = qu.poll();

            for (int n : list.get(curr)) {
                result[n] = Math.max(result[n], result[curr] + times[n]);
                indegree[n]--;

                if (indegree[n] == 0) {
                    qu.offer(n);
                }
            }
        }

        return result[w];
    }
}