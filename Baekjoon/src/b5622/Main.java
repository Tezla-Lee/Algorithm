package b5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine().trim();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int num = c;
            if (num <= 79) {
                answer += (((int) c - 65) / 3) + 3;
            } else if (num <= 83) {
                answer += 8;
            } else if (num <= 86) {
                answer += 9;
            } else {
                answer += 10;
            }
        }
        System.out.println(answer);
    }
}