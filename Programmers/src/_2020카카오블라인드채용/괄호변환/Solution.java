package _2020카카오블라인드채용.괄호변환;

import java.util.Arrays;

public class Solution {
    public String solution(String p) {
        String answer = "";
        String[] uv;
        return answer;
    }

    // 올바른 괄호 문자열 확인
    public static boolean rightBrackets(String s) {
        int count = 0;
        String[] strings = s.split("");
        for (String st : strings) {
            if (st.equals("(")) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // u, v로 나누기
    public static String[] divideUV(String s) {
        int count = 0;
        String[] strings = s.split("");
        String[] uv = new String[2];
        for (int i = 0; i < s.length(); i++) {
            if (strings[i].equals("(")) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                uv[0] = s.substring(0, i + 1);
                uv[1] = s.substring(i + 1);
                return uv;
            }
        }
        uv[0] = s;
        uv[1] = "";
        return uv;
    }

    public static String divideU(String s) {
        int count = 0;
        String[] strings = s.split("");
        String[] uv = new String[2];
        for (int i = 0; i < s.length(); i++) {
            if (strings[i].equals("(")) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return s.substring(0, i + 1);
            }
        }
        return s;
    }

    public static String divideV(String s) {
        int count = 0;
        String[] strings = s.split("");
        String[] uv = new String[2];
        for (int i = 0; i < s.length(); i++) {
            if (strings[i].equals("(")) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return s.substring(i + 1);
            }
        }
        return "";
    }

    public static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        if (rightBrackets(divideU(s))) {
            divideV(s);
        }
        return "";
    }

    public static void main(String[] args) {
//        System.out.println(rightBrackets("(())()"));
//        System.out.println(rightBrackets("(("));
//        System.out.println(rightBrackets("()"));
//        System.out.println(rightBrackets("))(("));
        System.out.println(Arrays.toString(divideUV("(())()()")));
        System.out.println(Arrays.toString(divideUV(")(()()")));
    }
}