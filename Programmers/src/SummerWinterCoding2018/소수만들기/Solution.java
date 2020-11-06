package SummerWinterCoding2018.소수만들기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int l = nums.length;
        primaryNum(nums[l - 1] + nums[l - 2] + nums[l - 3]);
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (primeNumbers[nums[i] + nums[j] + nums[k]] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    static int[] primeNumbers;

    public void primaryNum(int n) {
        primeNumbers = new int[n + 1];
        primeNumbers[0] = 1;
        primeNumbers[1] = 1;
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                primeNumbers[j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().solution(new int[]{1, 2, 7, 6, 4}));
    }
}
