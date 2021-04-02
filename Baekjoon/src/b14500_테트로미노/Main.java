package b14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int max;
    static int[][] board;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        board = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = true;
                tetromino(i, j, 0, 0);
                isVisited[i][j] = false;
            }
        }

        tetromino();

        System.out.println(max);
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void tetromino(int row, int col, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && !isVisited[nr][nc]) {
                isVisited[nr][nc] = true;
                tetromino(nr, nc, sum + board[nr][nc], depth + 1);
                isVisited[nr][nc] = false;
            }
        }
    }

    // ㅜ 4가지
    static void tetromino() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = board[i][j];
                int min = Integer.MAX_VALUE;
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k];
                    int nc = j + dy[k];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        count++;
                        sum += board[nr][nc];
                        min = Math.min(min, board[nr][nc]);
                    }
                }

                if (count == 4) {
                    max = Math.max(max, sum - min);
                } else if (count == 3) {
                    max = Math.max(max, sum);
                }
            }
        }
    }
}