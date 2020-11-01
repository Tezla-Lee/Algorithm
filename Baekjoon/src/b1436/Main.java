package b1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int number = 0;
        int count = 0;
        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }
            if (count == n) {
                System.out.println(number);
                break;
            }
                number++;
        }
    }
}