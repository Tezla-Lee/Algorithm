package level1.문자열내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String[] strings = s.split("");
        Arrays.sort(strings, (a, b) -> b.charAt(0) - a.charAt(0));

        for (String string : strings) {
            answer.append(string);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("Zbcdefg"));
    }
}
