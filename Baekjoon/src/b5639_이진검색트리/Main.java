package b5639_이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] nodes = new int[10001][2];
        int prev = Integer.MAX_VALUE;

        while (true) {
            String s = br.readLine();
            if (s.equals("")) {
                break;
            }
            int num = Integer.parseInt(s);
            nodes[num][0] = 1;

        }
    }
}