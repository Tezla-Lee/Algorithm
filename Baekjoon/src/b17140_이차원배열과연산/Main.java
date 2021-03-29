package b17140_이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int maxRow;
    static int maxCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[100][100];

        maxRow = 3;
        maxCol = 3;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (board[r - 1][c - 1] != k && count < 100) {
            if (maxRow >= maxCol) {
                calculateR();
            } else {
                calculateC();
            }
            count++;
        }

        if (count == 100 && board[r - 1][c - 1] != k) {
            System.out.println("-1");
        } else {
            System.out.println(count);
        }
    }

    static void calculateR() {
        HashMap<Integer, Integer> map;
        PriorityQueue<Number> pq;
        int[][] tempBoard = new int[100][100];
        int tempCol = 0;

        for (int i = 0; i < maxRow; i++) {
            map = new HashMap<>();
            pq = new PriorityQueue<>();

            for (int j = 0; j < maxCol; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new Number(entry.getKey(), entry.getValue()));
            }

            int col = 0;

            while (!pq.isEmpty()) {
                Number num = pq.poll();

                tempBoard[i][col++] = num.value;
                tempBoard[i][col++] = num.count;
            }

            tempCol = Math.max(tempCol, col);
        }
        maxCol = tempCol;
        board = tempBoard;
    }

    static void calculateC() {
        HashMap<Integer, Integer> map;
        PriorityQueue<Number> pq;
        int[][] tempBoard = new int[100][100];
        int tempRow = 0;

        for (int i = 0; i < maxCol; i++) {
            map = new HashMap<>();
            pq = new PriorityQueue<>();

            for (int j = 0; j < maxRow; j++) {
                if (board[j][i] == 0) {
                    continue;
                }
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new Number(entry.getKey(), entry.getValue()));
            }

            int row = 0;

            while (!pq.isEmpty()) {
                Number num = pq.poll();
                tempBoard[row++][i] = num.value;
                tempBoard[row++][i] = num.count;
            }

            tempRow = Math.max(tempRow, row);
        }
        maxRow = tempRow;
        board = tempBoard;
    }

    static void printBoard() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Number implements Comparable<Number> {
    int value;
    int count;

    public Number(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Number o) {
        return count == o.count ? value - o.value : count - o.count;
    }
}