package 연습문제.동적계획법.도둑질;

class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        dp1[1] = money[0];
        dp2[1] = money[1];
        for (int i = 2; i < dp1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        return Math.max(dp1[money.length - 1], dp2[money.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 10, 9, 1, 3, 10}));
    }
}