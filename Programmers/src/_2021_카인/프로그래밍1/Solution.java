package _2021_카인.프로그래밍1;

class Solution {
    private final String[] englishNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        return convertToNumber(s);
    }

    private int convertToNumber(String s) {
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(englishNum[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
