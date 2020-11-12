package b1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isVisited = new boolean[n][n];
                dfs(i, j, 1);
                if (maxDay == n * n) {
                    break;
                }
            }
        }
        System.out.println(maxDay);
    }

    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxDay = Integer.MIN_VALUE;

    public static void dfs(int x, int y, int day) {
        isVisited[x][y] = true;
        maxDay = Math.max(day, maxDay);
//        System.out.print(board[x][y] + " ");
        int tempX;
        int tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < board.length && tempY < board[0].length) {
                if (!isVisited[tempX][tempY] && board[tempX][tempY] > board[x][y]) {
                    dfs(tempX, tempY, day + 1);
                }
            }
        }
    }
}
