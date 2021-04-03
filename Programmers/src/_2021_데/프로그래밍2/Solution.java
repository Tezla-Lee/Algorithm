package _2021_데.프로그래밍2;

class Solution {
    int min; // 돌릴 때 최소값 저장

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows + 1][columns + 1];
        int num = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            board = rotate(queries[i], board);
            answer[i] = min;
        }

        return answer;
    }

    int[][] rotate(int[] query, int[][] board) {
        min = Integer.MAX_VALUE;
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int[][] rotateBoard = new int[board.length][];

        for (int i = 0; i < board.length; i++) {
            rotateBoard[i] = board[i].clone();
        }

        // 상
        for (int i = y1; i < y2; i++) {
            rotateBoard[x1][i + 1] = board[x1][i];
            min = Math.min(min, board[x1][i]);
        }

        // 우
        for (int i = x1; i < x2; i++) {
            rotateBoard[i + 1][y2] = board[i][y2];
            min = Math.min(min, board[i][y2]);
        }

        // 하
        for (int i = y2; i > y1; i--) {
            rotateBoard[x2][i - 1] = board[x2][i];
            min = Math.min(min, board[x2][i]);
        }

        // 좌
        for (int i = x2; i > x1; i--) {
            rotateBoard[i - 1][y1] = board[i][y1];
            min = Math.min(min, board[i][y1]);
        }

        return rotateBoard;
    }
}