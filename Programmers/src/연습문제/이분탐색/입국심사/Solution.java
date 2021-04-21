package 연습문제.이분탐색.입국심사;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * times[times.length - 1];
        long middle = 0;
        long sum = 0;
        Arrays.sort(times);
        while (right >= left) {
            sum = 0;
            middle = (right + left) / 2;
            for (int i = 0; i < times.length; i++) {
                sum += middle / times[i];
            }
            if (sum > n) {
                right = middle - 1;
            } else if (sum < n) {
                left = middle + 1;
            } else {
                while (sum >= n) {
                    middle--;
                    sum = 0;
                    for (int i = 0; i < times.length; i++) {
                        sum += middle / times[i];
                    }
                }
                return middle + 1;
            }
        }

        while (sum >= n) {
            middle--;
            sum = 0;
            for (int time : times) {
                sum += middle / time;
            }
        }
        return middle + 1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(6, new int[]{7, 10, 100}));
//        System.out.println(new Solution().solution(6, new int[]{7, 4, 9, 100}));
        System.out.println(new Solution().solution(6, new int[]{1, 2, 3, 10000000}));
//        System.out.println(new Solution().solution(6, new int[]{1, 2, 10000000}));
//        System.out.println(new Solution().solution(6, new int[]{1, 2, 10000000}));
    }
}