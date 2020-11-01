package b3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Double r = Double.valueOf(br.readLine());
        sb.append(Math.PI * r * r).append("\n").append(2 * r * r);
        System.out.println(sb);
    }
}
