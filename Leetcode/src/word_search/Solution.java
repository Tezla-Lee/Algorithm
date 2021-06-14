package word_search;

class Solution {
    private final int[] dr = {0, 0, 1, -1};
    private final int[] dc = {1, -1, 0, 0};
    private boolean flag;
    private char[] word;
    private char[][] board;
    private boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == this.word[0]) {
                    isVisited[i][j] = true;
                    searchWord(i, j, 0);
                    isVisited[i][j] = false;

                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void searchWord(int row, int col, int index) {
        if (index == word.length - 1) {
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !isVisited[nr][nc]) {
                if (board[nr][nc] == word[index + 1]) {
                    isVisited[nr][nc] = true;
                    searchWord(nr, nc, index + 1);
                    isVisited[nr][nc] = false;
                }
            }
        }
    }
}