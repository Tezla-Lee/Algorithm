package b1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        int number = 0;
        int sum = 1;
        int answer = 0;
        int[] numbers = new int[b + 1];
        for (int i = 1; i <= b; i++) {
            if (i == sum) {
                number++;
                sum += number;
            }
            numbers[i] = number;
        }
        for (int i = a; i <= b; i++) {
            answer += numbers[i];
        }
        System.out.println(answer);
    }
}
