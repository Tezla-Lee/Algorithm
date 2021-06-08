package b1103_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] board;
    private static int[][] counts;
    private static boolean[][] isVisited;
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        counts = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] nums = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = nums[j];
            }
        }
        isVisited[0][0] = true;
        System.out.println(getCount(0, 0));
    }

    private static int getCount(int row, int col) {
        if (board[row][col] == 'H') {
            return 0;
        }

        int jump = board[row][col] - '0';
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int nr = row + jump * dr[i];
            int nc = col + jump * dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                flag = true;

                if (isVisited[nr][nc]) {
                    return -1;
                }

                isVisited[nr][nc] = true;

                int count;
                if (counts[nr][nc] > 0) {
                    count = counts[nr][nc];
                } else {
                    count = getCount(nr, nc);
                }

                isVisited[nr][nc] = false;

                if (count == -1) {
                    return -1;
                }

                counts[row][col] = Math.max(counts[row][col], count + 1);
            }
        }

        if (!flag) {
            return 1;
        }

        return counts[row][col];
    }
}