package b1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lanWires = new int[k];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            lanWires[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanWires[i]);
        }

        System.out.println(binarySearch(lanWires, max, n));
    }

    static long binarySearch(int[] arr, int max, int n) {
        long left = 1;
        long mid;
        long right = max;
        int ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println(left + " " + mid + " " + right);

            long sum = 0;
            for (int lan : arr) {
                sum += lan / mid;
            }

            if (sum < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = (int) Math.max(ans, mid);
            }
        }

        return ans;
    }
}
