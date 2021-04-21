package 연습문제.완전탐색.소수찾기;

public class Solution {
    public int solution(String numbers) {
        nums = numbers.split("");
        arr = new String[nums.length];
        primeNum = new boolean[(int) Math.pow(10, nums.length + 1)];
        primeNum[0] = true;
        primeNum[1] = true;

        for (int i = 2; i * i < primeNum.length; i++) {
            for (int j = i * i; j < primeNum.length; j += i) {
                primeNum[j] = true;
            }
        }
        count = 0;
        sb = new StringBuilder();
        for (int i = 1; i <= nums.length; i++) {
            isUsed = new boolean[nums.length];
            dfs(i, 0);
        }
        return count;
    }

    static String[] arr;
    static boolean[] isUsed, primeNum;
    static String[] nums;
    static StringBuilder sb;
    static int count;

    static void dfs(int length, int index) {
        if (index == length) {
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]);
            }
            if (!primeNum[Integer.parseInt(sb.toString())]) {
                primeNum[Integer.parseInt(sb.toString())] = true;
                count++;
            }
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                arr[index] = nums[i];
                isUsed[i] = true;
                dfs(length, index + 1);
                isUsed[i] = false;
            }
        }
    }
}