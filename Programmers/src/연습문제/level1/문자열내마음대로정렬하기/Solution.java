package 연습문제.level1.문자열내마음대로정렬하기;

import java.util.Arrays;

public class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);
        });
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"sun", "bed", "car"}, 1)));
    }
}
