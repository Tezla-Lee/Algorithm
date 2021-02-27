package _2020_카카오블라인드채용.기둥과보설치;

import java.util.Arrays;

public class Solution2 {
    // [x, y, a, b]
    // a : 0 기둥 1 보
    // b : 0 삭제 1 설치
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] board = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(board[i], -1);
        }

        // x, y, 기둥 0 보 1, 삭제 0 설치 1
        for (int[] arr : build_frame) {
            int x = arr[0];
            int y = arr[1];

            if (arr[2] == 0) { // 기둥
                if (arr[3] == 1) { // 설치
                    // 바닥 or 아래에 기둥 or 왼쪽에 보
                    if (y == 0 || board[x][y - 1] == 0 || (x > 0 && board[x - 1][y] == 1)) {
                        board[x][y] = 0;
                    }
                } else { // 삭제
                    if (board[x][y + 1] == 1) { // 기둥위에 보가 있을 때
                        // 그 보의 양쪽이 보로 연결 or 보의 오른쪽에 기둥 연결
                        if ((board[x - 1][y + 1] == 1 && board[x + 1][y + 1] == 1) || board[x + 1][y] == 0) {
                            board[x][y] = -1;
                        }
                    }

                    if (board[x][y + 1] == 0) { // 위에 기둥이 있을 때
                        if (board[x - 1][y + 1] == 1 || board[x + 1][y + 1] == 1) { // 양 쪽에 보가 있으면
                            board[x][y] = -1;
                        }
                    }
                }
            } else { // 보
                if (arr[3] == 1) { // 설치
                    // 아래 기둥이 있거나, 양 쪽이 보가 있으면
                    if (board[x][y - 1] == 0 || board[x + 1][y - 1] == 0 || (board[x - 1][y] == 1 && board[x + 1][y] == 1)) {
                        board[x][y] = 1;
                    }
                } else { // 삭제
                    if (board[x - 1][y] == 1) {
                        if (board[x - 1][y - 1] != 0 && board[x][y - 1] != 0) {

                        }
                    }
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.println();
            for (int j = 0; j < n + 1; j++) {
                if (board[j][i] == -1) {
                    System.out.printf("  .");
                } else {
                    System.out.printf("%3d", board[j][i]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution2().solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        System.out.println();
        new Solution2().solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }
}