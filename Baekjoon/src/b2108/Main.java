package b2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        int number;
        int countMax = Integer.MIN_VALUE;
        int countNum = 0;
        int count2 = 0;
        int[] numbers = new int[n];
        int[] count = new int[8001];
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(br.readLine());
            count[number + 4000]++;
            max = Math.max(max, number);
            min = Math.min(min, number);
            sum += number;
            numbers[i] = number;
        }
        for (int i = 0; i < count.length; i++) {
            countMax = Math.max(countMax,count[i]);
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == countMax) {
                countNum = i - 4000;
                count2++;
            }
            if (count2 == 2) {
                break;
            }
        }
        Arrays.sort(numbers);
        System.out.println(Math.round(sum / n) + "\n" +
                numbers[n/2] + "\n" +
                countNum + "\n" +
                (max - min)
        );
    }
}