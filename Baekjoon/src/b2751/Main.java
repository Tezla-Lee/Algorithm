package b2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            check[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                sb.append(i - 1000000 + "\n");
            }
        }
        System.out.println(sb);
    }
}