package b2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        money = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            money[i] = value;
            max = Math.max(max, value);
        }

        Arrays.sort(money);

        System.out.println(binarySearch());

    }

    static int n;
    static int m;
    static int[] money;
    static int max = Integer.MIN_VALUE;

    static long binarySearch() {
        long left = 0;
        long right = max;
        while (left <= right) {
            long mid = (left + right) >> 1;

            if (sumPrice(mid) <= m) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return right;
    }

    static long sumPrice(long mid) {
        long sum = 0;
        for (long k : money) {
            sum += Math.min(k, mid);
        }
        return sum;
    }
}