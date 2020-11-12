package b1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split(" ");
        }

        isVisited2 = new boolean[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited2[i][j]) {
                    dfs(i, j, 1);
//                    System.out.println();
                    if (maxDay == n * n) {
                        break;
                    }
                }
            }
        }
        System.out.println(maxDay);
    }

    static String[][] board;
    static boolean[][] isVisited;
    static boolean[][] isVisited2;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxDay = Integer.MIN_VALUE;

    public static void dfs(int x, int y, int day) {
        isVisited[x][y] = true;
        isVisited2[x][y] = true;
//        System.out.print(board[x][y] + " ");
        maxDay = Math.max(day, maxDay);
//        System.out.println(maxDay);
        int tempX;
        int tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < board.length && tempY < board.length) {
                if (!isVisited[tempX][tempY]) {
                    if (Integer.parseInt(board[tempX][tempY]) > Integer.parseInt(board[x][y])) {
                        dfs(tempX, tempY, day + 1);
                    }
                }
            }
        }
        isVisited[x][y] = false;
    }
}
