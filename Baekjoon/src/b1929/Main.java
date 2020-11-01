package b1929;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[] primeNumbers = new int[n + 1];
        for (long i = 2; i * i <= n; i++) {
            for (long j = i * i; j <= n; j += i) {
                primeNumbers[(int)j] = 1;
            }
        }
        primeNumbers[1] = 1;
        primeNumbers[0] = 1;
        for (int i = m; i <= n; i++) {
            if (primeNumbers[i] == 0) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}