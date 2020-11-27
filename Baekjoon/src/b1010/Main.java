package b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            num[1][i] = 1;
        }
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    num[i][j] = 1;
                } else {
                    num[i][j] = (num[i][j - 1] + num[i - 1][j]) % 10007;
                }
                if (i == n) sum += num[i][j];
            }
        }
        System.out.println(sum % 10007);
    }
}