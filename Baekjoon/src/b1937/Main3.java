package b1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        board2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split(" ");
        }

        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxDay = Math.max(dfs(i, j, 1) + 1, maxDay);
            }
        }
        System.out.println(maxDay);
    }

    static String[][] board;
    static int[][] board2;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxDay = Integer.MIN_VALUE;

    public static int dfs(int x, int y, int day) {
        isVisited[x][y] = true;

        if (board2[x][y] != 0) {
            return board2[x][y];
        }
        int tempX;
        int tempY;
        int day2 = 1;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < board.length && tempY < board.length) {
                if (Integer.parseInt(board[x][y]) < Integer.parseInt(board[tempX][tempY])) {
                    day2 = Math.max(dfs(tempX, tempY, day + 1), day);
                }
            }
        }
        isVisited[x][y] = false;
        return day2;
    }
}
