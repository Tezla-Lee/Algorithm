package b1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        int[] numbers = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < roomNumber.length(); i++) {
            numbers[Integer.parseInt(String.valueOf(roomNumber.charAt(i)))]++;
        }
        numbers[6] += numbers[9] + 1;
        numbers[6] /= 2;
        numbers[9] = 0;
        for (int i = 0; i < numbers.length; i++) {
                max = Math.max(max, numbers[i]);
        }
        System.out.println(max);
    }
}
