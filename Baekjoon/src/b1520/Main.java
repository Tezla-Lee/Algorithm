package b1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        dfs(1, 1);

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n][m]);

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] dp;
    static int n, m;

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX > 0 && nextY > 0 && nextX < n + 1 && nextY < m + 1 && map[x][y] > map[nextX][nextY]) {
                if (dp[nextX][nextY] == 0) {
                    dp[nextX][nextY] += dp[x][y];
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
