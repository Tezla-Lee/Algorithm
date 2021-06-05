package _2021_라핀인.프로그래밍1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int inputIndex;
    private int cookiesIndex;
    private char[] inputChars;
    private List<Character> cookies;

    public int solution(String inputString) {
        inputChars = inputString.toCharArray();
        inputIndex = 0;
        cookiesIndex = 0;

        cookies = new ArrayList<>();

        int n = 0;

        // N 찾을 때까지 반복
        while (!comparisonCookies()) { // 쿠키 비교
            addNCookies(++n); // N 못 찾으면 쿠키 추가
        }

        return n;
    }

    // 쿠키 비교
    private boolean comparisonCookies() {
        while (cookiesIndex < cookies.size()) {
            if (inputChars[inputIndex] == cookies.get(cookiesIndex)) {
                inputIndex++;
            }
            cookiesIndex++;

            if (inputChars.length == inputIndex) { // 전부 통과
                return true;
            }
        }
        return false;
    }

    // n 쿠키 추가
    private void addNCookies(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        for (char num : nums) {
            cookies.add(num);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("12345678910111213"));
        System.out.println(new Solution().solution("111"));
    }
}