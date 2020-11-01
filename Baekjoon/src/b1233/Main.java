package b1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dices = br.readLine().split(" ");
        int dice1 = Integer.parseInt(dices[0]);
        int dice2 = Integer.parseInt(dices[1]);
        int dice3 = Integer.parseInt(dices[2]);
        int[] sum = new int[81];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= dice1; i++) {
            for (int j = 1; j <= dice2; j++) {
                for (int k = 1; k <= dice3; k++) {
                    sum[i + j + k]++;
                }
            }
        }

        for (int i = 0; i < sum.length; i++) {
            max = Math.max(max, sum[i]);
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == max) {
                System.out.println(i);
                break;
            }
        }
    }
}
