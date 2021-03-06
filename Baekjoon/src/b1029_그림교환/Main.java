package b1029_그림교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        isBought = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] prices = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j + 1] = Integer.parseInt(prices[j]);
            }
        }

        isBought[1] = true;
        dfs(1, 0, 1);
        System.out.println(max);
    }

    static int n;
    static int max = Integer.MIN_VALUE;
    static int[][] graph;
    static boolean[] isBought;

    static void dfs(int artist, int currPrice, int count) {
        max = Math.max(max, count);

        for (int i = 1; i <= n; i++) {
            if (!isBought[i] && graph[artist][i] >= currPrice) {
                isBought[i] = true;
                dfs(i, graph[artist][i], count + 1);
                isBought[i] = false;
            }
        }
    }

}