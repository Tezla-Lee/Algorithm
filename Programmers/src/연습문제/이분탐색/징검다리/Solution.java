package 연습문제.이분탐색.징검다리;

import java.util.Arrays;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] arr = new int[rocks.length + 1];
        Arrays.sort(rocks);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = rocks[0];
            } else if (i == arr.length - 1) {
                arr[i] = distance - rocks[i - 1];
            } else {
                arr[i] = rocks[i] - rocks[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr));

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}