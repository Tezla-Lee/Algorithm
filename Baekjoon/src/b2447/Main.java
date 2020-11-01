package b2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(printStar(Integer.parseInt(br.readLine())));
    }

    static String printStar(int n) {
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution(i, j, n);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void solution(int i, int j, int mod) {
        mod /= 3;
        if ((i / mod) % 3 == 1 && (j / mod) % 3 == 1) {
            sb.append(" ");
        } else {
            if (mod == 1) {
                if (i % 3 == 1 && j % 3 == 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
                return;
            }
            solution(i, j, mod);
        }
    }
}