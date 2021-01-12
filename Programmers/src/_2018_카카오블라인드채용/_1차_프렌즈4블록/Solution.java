package _2018_카카오블라인드채용._1차_프렌즈4블록;

public class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] board2 = new char[m][n];
        for (int i = 0; i < m; i++) {
            board2[i] = board[i].toCharArray();
        }
        for (char[] a : board2) {
            for (char b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }
}
