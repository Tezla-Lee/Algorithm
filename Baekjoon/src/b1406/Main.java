package b1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int cursor = sb.length();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.charAt(0) == 'L') {
                if (cursor > 0) {
                    cursor--;
                }
            } else if (command.charAt(0) == 'D') {
                if (sb.length() > cursor) {
                    cursor++;
                }
            } else if (command.charAt(0) == 'B') {
                if (cursor > 0) {
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                }
            } else if (command.charAt(0) == 'P') {
                if (cursor >= 0) {
                    sb.replace(cursor, sb.length(), command.substring(2) + sb.substring(cursor));
                    cursor++;
                }
            }
        }
        System.out.println(sb);
    }
}
