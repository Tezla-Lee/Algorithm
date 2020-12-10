package b1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int[] lanWires = new int[k];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lanWires[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanWires[i]);
        }
        long left = 1;
        long right = max;

        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < k; i++) {
                sum += lanWires[i] / mid;
            }
            if (sum >= n) {
                left = mid + 1;
                ans = (int) Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}