package b10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        isUsed = new boolean[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        go(0);
        System.out.println(max);
    }

    static int[] numbers;
    static boolean[] isUsed;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    static void go(int depth) {
        if (depth == arr.length) {
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                sum += Math.abs(arr[i] - arr[i - 1]);
            }
            max = Math.max(sum, max);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = numbers[i];
                go(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}