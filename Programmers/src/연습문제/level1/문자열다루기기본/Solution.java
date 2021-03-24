package 연습문제.level1.문자열다루기기본;

public class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            char[] characters = s.toCharArray();
            for (char c : characters) {
                if (c < 48 || c >57) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}