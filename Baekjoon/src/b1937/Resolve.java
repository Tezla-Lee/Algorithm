package b1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static int n;
    static int max = 1;
    static int[][] forest;
    static int[][] dp;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        dp[row][col] = 1;
        isVisited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int tempX = row + dx[i];
            int tempY = col + dy[i];

            if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < n) {
                if (forest[tempX][tempY] > forest[row][col]) {
                    dp[row][col] = Math.max(dp[row][col], dfs(tempX, tempY) + 1);
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return dp[row][col];
    }
}