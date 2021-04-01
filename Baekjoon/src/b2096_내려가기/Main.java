package b2096_내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        printMaxAndMin();
    }

    static void printMaxAndMin() {
        int[][] dMax = new int[n][3];
        int[][] dMin = new int[n][3];
        dMax[0] = board[0];
        dMin[0] = board[0];

        for (int i = 1; i < n; i++) {
            setMax(dMax, i);
            setMin(dMin, i);
        }

        int max = Math.max(Math.max(dMax[n - 1][0], dMax[n - 1][1]), dMax[n - 1][2]);
        int min = Math.min(Math.min(dMin[n - 1][0], dMin[n - 1][1]), dMin[n - 1][2]);

        System.out.println(max + " " + min);
    }


    static void setMin(int[][] d, int index) {
        int min0 = Math.min(d[index - 1][0], d[index - 1][1]);
        int min2 = Math.min(d[index - 1][2], d[index - 1][1]);
        int min1 = Math.min(min0, min2);

        d[index][0] = min0 + board[index][0];
        d[index][1] = min1 + board[index][1];
        d[index][2] = min2 + board[index][2];
    }

    static void setMax(int[][] d, int index) {
        int max0 = Math.max(d[index - 1][0], d[index - 1][1]);
        int max2 = Math.max(d[index - 1][2], d[index - 1][1]);
        int max1 = Math.max(max0, max2);

        d[index][0] = max0 + board[index][0];
        d[index][1] = max1 + board[index][1];
        d[index][2] = max2 + board[index][2];
    }
}