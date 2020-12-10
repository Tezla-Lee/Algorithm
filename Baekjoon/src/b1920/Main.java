package b1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(numbers);
        for (int i = 0; i < m; i++) {
            binarySearch(0, n - 1, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    static void binarySearch(int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                sb.append("1\n");
                return;
            }
        }
        sb.append("0\n");
    }
}