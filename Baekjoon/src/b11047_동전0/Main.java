package b11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            while (k >= coins[coins.length - 1 - i]) {
                count += k / coins[coins.length - 1 - i];
                k = k % coins[coins.length - 1 - i];
            }
            if (k == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}