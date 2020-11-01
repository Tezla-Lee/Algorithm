package b1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[] firstName = new char[123];
        for (int i = 0; i < n; i++) {
            firstName[br.readLine().charAt(0)]++;
        }
        for (int i = 97; i <= 122; i++) {
            if (firstName[i] >= 5) {
                sb.append((char) i);
            }
        }
        if (sb.length() == 0) {
            sb.append("PREDAJA");
        }
        System.out.println(sb);
    }
}
