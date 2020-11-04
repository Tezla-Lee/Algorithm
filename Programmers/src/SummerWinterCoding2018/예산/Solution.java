package SummerWinterCoding2018.예산;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i : d) {
            budget -= i;
            if (budget < 0) {
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 2, 5, 4,}, 9));
    }
}
