package b1526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int temp = n;
        int first;
        int end;
        int digits = 1;
        first = n % 10;
        while (true) {
            temp /= 10;
            digits++;
            if (temp / 10 == 0) {
                end = temp;
                break;
            }
        }
        while (digits != 0) {
            if (end >= 7) {
                sb.append(7);
            }
        }
    }
}
