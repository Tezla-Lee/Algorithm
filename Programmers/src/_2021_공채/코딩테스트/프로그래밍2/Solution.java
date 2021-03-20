package _2021_공채.코딩테스트.프로그래밍2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String inp_str) {
        List<Integer> list = new ArrayList<>();

        if (!isPossibleLength(inp_str)) {
            list.add(1);
        }

        if (!isPossibleLetters(inp_str)) {
            list.add(2);
        }

        if (!includeThreeOrMoreKindsOfChar(inp_str)) {
            list.add(3);
        }

        if (isFourConsecutiveSameChar(inp_str)) {
            list.add(4);
        }

        if (HaveFiveOrMoreSameChar(inp_str)) {
            list.add(5);
        }

        if (list.isEmpty()) {
            return new int[]{0};
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 1번 조건
    static boolean isPossibleLength(String pw) {
        return pw.length() >= 8 && pw.length() <= 15;
    }

    // 2번 조건
    static boolean isPossibleLetters(String pw) {
        char[] pwChars = pw.toCharArray();

        for (char c : pwChars) {
            if (!(Character.isDigit(c) || Character.isAlphabetic(c) || isPossibleSpecialChar(c))) {
                return false;
            }
        }

        return true;
    }

    static boolean isPossibleSpecialChar(char c) {
        return c == '~' || c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*';
    }

    // 3번 조건
    static boolean includeThreeOrMoreKindsOfChar(String pw) {
        int[] haveKind = new int[4];

        char[] pwChars = pw.toCharArray();

        for (char c : pwChars) {
            if (Character.isDigit(c)) {
                haveKind[0] = 1;
            } else if (Character.isLowerCase(c)) {
                haveKind[1] = 1;
            } else if (Character.isUpperCase(c)) {
                haveKind[2] = 1;
            } else if (isPossibleSpecialChar(c)) {
                haveKind[3] = 1;
            }
        }

        int count = 0;

        for (int i : haveKind) {
            count += i;
        }

        return count >= 3;
    }

    // 4번 조건
    static boolean isFourConsecutiveSameChar(String pw) {
        char[] pwChars = pw.toCharArray();
        int count = 1;

        for (int i = 1; i < pwChars.length; i++) {
            if (pwChars[i] == pwChars[i - 1]) {
                count++;

                if (count == 4) {
                    return true;
                }
            } else {
                count = 1;
            }
        }

        return false;
    }

    // 5번 조건
    static boolean HaveFiveOrMoreSameChar(String pw) {
        char[] pwChars = pw.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pwChars) {
            int count = map.getOrDefault(c, 0) + 1;

            if (count == 5) {
                return true;
            }

            map.put(c, count);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("AaTa+!12-3")));
        System.out.println(Arrays.toString(new Solution().solution("aaaaZZZZ)")));
        System.out.println(Arrays.toString(new Solution().solution("CaCbCgCdC888834A")));
        System.out.println(Arrays.toString(new Solution().solution("UUUUU")));
        System.out.println(Arrays.toString(new Solution().solution("ZzZz9Z824")));
    }
}