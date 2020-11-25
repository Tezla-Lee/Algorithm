package b2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
                if (temp == 0) {
                    count++;
                }
            }
        }
        dfs(0, 0);
    }

    static int[][] board = new int[9][9];
    static int count;

    static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(i, row, col)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    static boolean isPossible(int value, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value) {
                return false;
            }
            if (board[i][y] == value) {
                return false;
            }
        }
        int tempX = (x / 3) * 3;
        int tempY = (y / 3) * 3;
        for (int i = tempX; i < tempX + 3; i++) {
            for (int j = tempY; j < tempY + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}

//2 0 6 3 0 0 1 0 5
//0 0 0 0 0 0 0 8 0
//0 9 0 0 1 0 0 2 0
//0 4 0 0 9 2 0 0 0
//0 0 1 0 8 0 6 0 0
//3 0 0 0 0 0 0 7 0
//0 0 3 9 0 0 0 0 0
//0 0 0 0 0 8 0 0 0
//0 0 7 6 4 0 0 0 3


//0 0 5 4 6 9 2 7 8
//7 0 0 1 0 5 6 0 9
//0 6 0 2 7 8 1 3 5
//3 2 1 0 4 6 8 9 7
//8 0 4 9 1 3 5 0 6
//5 9 6 8 2 0 4 1 3
//9 1 7 6 5 2 0 8 0
//6 0 3 7 0 1 9 5 2
//2 5 8 3 9 4 7 6 0