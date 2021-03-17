package 연습문제.최댓값최솟값;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] nums = s.split(" ");

        for (String num : nums) {
            int number = Integer.parseInt(num);

            max = Math.max(max, number);
            min = Math.min(min, number);
        }

        return min + " " + max;
    }
}
