package b11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        int[] lDp = new int[n + 1];
        int[] rDp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        lDp[1] = 1;
        rDp[n] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (lDp[i] == 0) {
                    lDp[i] = 1;
                }
                if (rDp[n + 1 - i] == 0) {
                    rDp[n + 1 - i] = 1;
                }
                if (numbers[j] < numbers[i]) {
                    lDp[i] = Math.max(lDp[j] + 1, lDp[i]);
                }
                if (numbers[n + 1 - j] < numbers[n + 1 - i]) {
                    rDp[n + 1 - i] = Math.max(rDp[n + 1 - j] + 1, rDp[n + 1 - i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, lDp[i] + rDp[i]);
        }
        System.out.println(max - 1);
    }
}