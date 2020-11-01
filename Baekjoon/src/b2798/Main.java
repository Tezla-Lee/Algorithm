package b2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        String[] numbers = br.readLine().split(" ");
        int m = Integer.parseInt(nm[1]);
        int sum;
        int max = Integer.MIN_VALUE;
        loop:
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    sum = Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[j]) + Integer.parseInt(numbers[k]);
                    if (sum <= m) {
                        max = Math.max(max, sum);
                        if (sum == m) {
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
