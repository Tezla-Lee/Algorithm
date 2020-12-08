package b1403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    isGone = new boolean[n];
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int board[][];
    static int answer[][];
    static boolean[] isGone;
    static int n;

    static void dfs(int row, int col) {

        answer[row][col] = 1;
        for (int i = 0; i < n; i++) {
            if (!isGone[i] && board[col][i] == 1) {
                isGone[i] = true;
                dfs(row, i);
            }
        }
    }
}