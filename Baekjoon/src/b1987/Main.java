package b1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        char[][] board = new char[r][c];

        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }
        move(board, 0, 0, 1);
        System.out.println(count);
    }

    //    static HashSet<String> moved = new HashSet<>(); // 겁나 느림
    static boolean[] moved = new boolean[123];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = Integer.MIN_VALUE;

    public static void move(char[][] board, int x, int y, int depth) {
        moved[board[x][y]] = true;
        count = Math.max(count, depth);
        int tempX, tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < board.length && tempY >= 0 && tempY < board[0].length) {
                if (!moved[board[tempX][tempY]]) {
                    move(board, tempX, tempY, depth + 1);
                }
            }
        }
        moved[board[x][y]] = false;
    }
}