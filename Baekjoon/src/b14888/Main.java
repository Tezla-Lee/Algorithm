package b14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        calculate(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static int operate(int a, int b, int c) {
        if (c == 0) {
            return a + b;
        } else if (c == 1) {
            return a - b;
        } else if (c == 2) {
            return a * b;
        } else if (c == 3) {
            return a / b;
        }
        return -1;
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void calculate(int num, int index) {
        if (index == arr.length) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (operator[j] > 0) {
                operator[j]--;
                calculate(operate(num, arr[index], j), index + 1);
                operator[j]++;
            }
        }
    }
}