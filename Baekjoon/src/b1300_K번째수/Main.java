package b1300_K번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(n, k, 1, k));
    }

    static long sum(long num, int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(num / i, n);
        }
        return sum;
    }

    static long binarySearch(int n, int k, long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;

            if (sum(mid, n) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}