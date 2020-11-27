package b1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(numbers[i]);
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
    }
}