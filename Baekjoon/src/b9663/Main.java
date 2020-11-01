package b9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        dfs(n, 0, board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    public static void queenMove(int n, int a, int b, int[][] board) {
        int ta = a;
        int tb = b;
        for (int i = 0; i < n; i++) {
            ta++;
            tb++;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            ta++;
            tb--;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            ta--;
            tb++;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            ta--;
            tb--;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            ta++;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            ta--;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            tb++;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
        ta = a;
        tb = b;
        for (int i = 0; i < n; i++) {
            tb--;
            if (0 <= ta && ta < n && 0 <= tb && tb < n) {
                if (board[ta][tb] ==3) {
                    continue;
                }
                board[ta][tb] = 1;
            } else {
                break;
            }
        }
    }

    public static void dfs(int n, int depth, int[][] board) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (board[depth][i] != 3) {
                board[depth][i] = 3;
                queenMove(n, depth, i, board);
                dfs(n, depth + 1, board);
//                board[depth][i] = false;
            }
        }
    }
}