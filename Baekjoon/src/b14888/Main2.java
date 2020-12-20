package b14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        operators = new int[4];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }


        calculate(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static int[] numbers;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int operate(int a, int b, int c) {
        if (c == 0) {
            return a + b;
        } else if (c == 1) {
            return a - b;
        } else if (c == 2) {
            return a * b;
        } else {
            return a / b;
        }
    }

    static void calculate(int num, int index) {
        if (index == numbers.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                calculate(operate(num, numbers[index], i), index + 1);
                operators[i]++;
            }
        }
    }
}