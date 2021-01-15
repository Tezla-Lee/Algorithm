package b12100_2048easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(board, 0);

        System.out.println(max);
    }

    static int n;
    static int max;

    static void move(int[][] board, int depth) {
        if (depth == 5) {
            return;
        }

        // 위로 이동
        int[][] resultBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            // 세로로 한줄씩 스택에 넣는다
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stack.add(board[j][i]);
                }
            }

            // 스택에서 빼면서 작업
            int index = 0;
            while (!stack.isEmpty()) {
                int a = stack.pop();
                if (!stack.isEmpty() && stack.peek() == a) {
                    stack.pop();
                    resultBoard[index][i] = a * 2;
                } else {
                    resultBoard[index][i] = a;
                }
                max = Math.max(resultBoard[index++][i], max);
            }
        }

        move(resultBoard, depth + 1);

        // 아래로 이동
        resultBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                if (board[j][i] != 0) {
                    stack.add(board[j][i]);
                }
            }

            int index = n - 1;
            while (!stack.isEmpty()) {
                int a = stack.pop();
                if (!stack.isEmpty() && stack.peek() == a) {
                    stack.pop();
                    resultBoard[index][i] = a * 2;
                } else {
                    resultBoard[index][i] = a;
                }
                max = Math.max(resultBoard[index--][i], max);
            }
        }

        move(resultBoard, depth + 1);

        // 오른쪽으로 이동
        resultBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    stack.add(board[i][j]);
                }
            }

            int index = n - 1;
            while (!stack.isEmpty()) {
                int a = stack.pop();
                if (!stack.isEmpty() && stack.peek() == a) {
                    stack.pop();
                    resultBoard[i][index] = a * 2;
                } else {
                    resultBoard[i][index] = a;
                }
                max = Math.max(resultBoard[i][index--], max);
            }
        }

        move(resultBoard, depth + 1);

        // 왼쪽으로 이동
        resultBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    stack.add(board[i][j]);
                }
            }

            int index = 0;
            while (!stack.isEmpty()) {
                int a = stack.pop();
                if (!stack.isEmpty() && stack.peek() == a) {
                    stack.pop();
                    resultBoard[i][index] = a * 2;
                } else {
                    resultBoard[i][index] = a;
                }
                max = Math.max(resultBoard[i][index++], max);
            }
        }

        move(resultBoard, depth + 1);
    }
}