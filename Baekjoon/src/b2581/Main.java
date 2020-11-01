package b2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        findPrimeNumbers(m, n);
    }

    public static void findPrimeNumbers(int m, int n) {
        int[] primeNumbers = new int[n + 1];
        int sum = 0;
        int small = 0;
        boolean isExist = false;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j * i <= n; j++) {
                primeNumbers[i * j] = 1;
            }
        }
        primeNumbers[1] = 1;
        primeNumbers[0] = 1;
        for (int i = m; i <= n; i++) {
            if (primeNumbers[i] == 0) {
                small = i;
                isExist = true;
                break;
            }
        }
        for (int i = m; i <= n; i++) {
            if (primeNumbers[i] == 0) {
                sum += i;
            }
        }
        if (isExist) {
            System.out.println(sum);
            System.out.println(small);
        } else {
            System.out.println(-1);
        }
    }
}