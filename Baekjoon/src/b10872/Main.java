package b10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nFactorial = 1;
        if (n == 0) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= n; i++) {
                nFactorial *= i;
            }
            System.out.println(nFactorial);
        }
    }
}
