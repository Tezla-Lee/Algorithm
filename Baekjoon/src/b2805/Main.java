package b2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(temp, max);
            trees[i] = temp;
        }
        int left = 0;
        int right = max;
        int mid = 0;
        int ans = Integer.MIN_VALUE;
        long sum;
        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }
            if (sum >= m) {
                left = mid + 1;
                ans = Math.max(mid, ans);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}