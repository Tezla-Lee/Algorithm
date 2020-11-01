package b4948;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count;
        int n;
        int[] primeNumbers;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> nList = new ArrayList<>();
        while (true) {
            n = Integer.parseInt(br.readLine());
            max = Math.max(max, n);
            nList.add(n);
            if (n == 0) {
                break;
            }
        }
        primeNumbers = new int[2 * max + 1];
        for (long i = 2; i * i <= 2 * max; i++) {
            for (long j = i * i; j <= 2 * max; j += i) {
                primeNumbers[(int) j] = 1;
            }
        }
        primeNumbers[1] = 1;
        primeNumbers[0] = 1;
        for (int m : nList) {
            if (m == 0) {
                break;
            }
            count = 0;
            for (int i = m + 1; i <= 2 * m; i++) {
                if (primeNumbers[i] == 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}