package b1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if (!isVisited[i][j]) {
                dfs(i, j);
//                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
//        System.out.println(count);
    }

    static int[][] board;
    static int[][] dp;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        isVisited[x][y] = true;
        count++;
        int tempX;
        int tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < board.length && tempY < board[0].length) {
                if (board[tempX][tempY] > board[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(tempX, tempY) + 1);
//                    dfs(tempX, tempY);
                }
            }
        }
        return dp[x][y];
    }
}