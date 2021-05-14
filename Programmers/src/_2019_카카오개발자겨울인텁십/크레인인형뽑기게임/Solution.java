package _2019_카카오개발자겨울인텁십.크레인인형뽑기게임;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    int doll = board[i][move - 1];
                    if (stack.isEmpty() || stack.peek() != doll) {
                        stack.push(board[i][move - 1]);
                    } else {
                        stack.pop();
                        count += 2;
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }
}