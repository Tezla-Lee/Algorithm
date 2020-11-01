package b1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[8][8];
        int count = 0;
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().split("");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (count++ %2 == 0 && board[i][j].equals("F")) {
                    answer++;
                }
            }
            count++;
        }
        System.out.println(answer);
    }
}
