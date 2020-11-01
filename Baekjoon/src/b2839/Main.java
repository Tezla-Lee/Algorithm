package b2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if ((n % 5) % 3 <= n / 5) {
            System.out.println(n / 5 + (n % 5) / 3 + n % 5 % 3);
        } else {
            System.out.println(-1);
        }
    }
}