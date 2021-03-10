package 이분탐색.입국심사;

public class Solution2 {
    public long solution(int n, int[] times) {

        return binarySearch(times, n);
    }

    static long binarySearch(int[] times, int n) {
        long maxTime = Long.MIN_VALUE;

        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }

        long left = 0;
        long right = n * maxTime;
        long mid = 0;

        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}