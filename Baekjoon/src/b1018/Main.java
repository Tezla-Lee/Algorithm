package b1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int h = Integer.parseInt(size[0]);
        int w = Integer.parseInt(size[1]);
        int count;
        int min = Integer.MAX_VALUE;
        String[][] board = new String[h][w];
        for (int i = 0; i < h; i++) {
            board[i] = br.readLine().split("");
        }
        String s;
        for (int a = 0; a < h - 7; a++) {
            for (int b = 0; b < w - 7; b++) {
                loop:
                for (int k = 0; k < 2; k++) {
                    count = 0;
                    if (k == 1) {
                        s= "B";
                    }
                    else {
                        s = "W";
                    }
                    for (int i = a; i < a + 8; i++) {
                        if (s.equals("B")) {
                            s = "W";
                        } else {
                            s = "B";
                        }
                        for (int j = b; j < b + 8; j++) {
//                            System.out.print(board[i][j]+ " ");
                            if (!board[i][j].equals(s)) {
                                count++;
                            }
                            if (count > min) {
//                                System.out.println();
                                continue loop;
                            }
                            if (s.equals("B")) {
                                s = "W";
                            } else {
                                s = "B";
                            }
                        }
//                        System.out.println();
                    }
                    min = Math.min(count, min);
//                    System.out.println(count);
                }
            }
        }
//        System.out.println();
        System.out.println(min);
    }
}