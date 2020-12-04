package 동적계획법.도둑질;

import java.util.Arrays;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length + 1];
        dp[1] = money[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i - 1]);
            if (i == dp.length -1 ) {

            }
        }
        System.out.println(Arrays.toString(dp));
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 1, 3, 10});
    }
}