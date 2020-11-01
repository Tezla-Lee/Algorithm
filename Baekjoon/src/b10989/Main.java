package b10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[10001];
        for (int i = 0; i < n; i++) {
            ints[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < ints.length; i++) {
            while (ints[i] > 0) {
                sb.append(i + "\n");
                ints[i]--;
            }
        }
        System.out.println(sb);
    }
}
