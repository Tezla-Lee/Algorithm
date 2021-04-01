package b2096_내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] dMin;
    static int[] dMax;
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
        dMax = board[0].clone();
        dMin = board[0].clone();

        for (int i = 1; i < n; i++) {
            setMax(i);
            setMin(i);
        }

        int max = Math.max(Math.max(dMax[0], dMax[1]), dMax[2]);
        int min = Math.min(Math.min(dMin[0], dMin[1]), dMin[2]);

        System.out.println(max + " " + min);
    }


    static void setMin(int index) {
        int min0 = Math.min(dMin[0], dMin[1]);
        int min2 = Math.min(dMin[2], dMin[1]);
        int min1 = Math.min(min0, min2);

        dMin[0] = min0 + board[index][0];
        dMin[1] = min1 + board[index][1];
        dMin[2] = min2 + board[index][2];
    }

    static void setMax(int index) {
        int max0 = Math.max(dMax[0], dMax[1]);
        int max2 = Math.max(dMax[2], dMax[1]);
        int max1 = Math.max(max0, max2);

        dMax[0] = max0 + board[index][0];
        dMax[1] = max1 + board[index][1];
        dMax[2] = max2 + board[index][2];
    }
}