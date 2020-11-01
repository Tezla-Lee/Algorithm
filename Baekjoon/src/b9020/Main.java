package b9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());
        int n;
        boolean[] primeNumbers = new boolean[10001];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i * i <= 10000; i++) {
            for (int j = i * i; j <= 10000; j += i) {
                primeNumbers[j] = false;
            }
        }

        for (int i = 0; i < caseNum; i++) {
            n = Integer.parseInt(br.readLine());
            for (int j = n / 2; ; j--) {
                if (primeNumbers[j] && primeNumbers[n - j]) {
                    sb.append(j).append(" ").append(n - j).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
