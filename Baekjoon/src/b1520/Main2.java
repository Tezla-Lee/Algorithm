package b1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int m;
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int dfs(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // 왔던 곳인지 확인
        if (dp[row][col] == -1) {
            dp[row][col] = 0;

            for (int i = 0; i < 4; i++) {
                int tempX = row + dx[i];
                int tempY = col + dy[i];

                if (tempX >= 0 && tempY >= 0 && tempX < m && tempY < n) {
                    if (map[row][col] > map[tempX][tempY]) {
                        dp[row][col] += dfs(tempX, tempY);
                    }
                }
            }
        }
        return dp[row][col];
    }
}