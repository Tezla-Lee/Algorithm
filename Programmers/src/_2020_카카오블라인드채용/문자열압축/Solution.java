package _2020_카카오블라인드채용.문자열압축;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            int begin = 0;
            int end = i;
            int count = 1;
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while (begin <= s.length()) {
                if (end > s.length()) {
                    sb.append(s.substring(begin));
                    break;
                }
                String subString = s.substring(begin, end);
                if (end + i <= s.length() && subString.equals(s.substring(begin + i, end + i))) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(subString);
                    } else {
                        sb.append(count).append(subString);
                        count = 1;
                    }
                }
                begin += i;
                end += i;
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution("aabbaccc"));
//        System.out.println(new Solution().solution("ababcdcdababcdcd"));
//        System.out.println(new Solution().solution("abcabcdede"));
//        System.out.println(new Solution().solution("abcabcabcabcdededededede"));
//        System.out.println(new Solution().solution("xababcdcdababcdcd"));
        System.out.println(new Solution().solution("a"));
    }
}
