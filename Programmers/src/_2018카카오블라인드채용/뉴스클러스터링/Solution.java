package _2018카카오블라인드채용.뉴스클러스터링;

import java.util.ArrayList;

public class Solution {
    public int solution(String str1, String str2) {
        int answer;
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        ArrayList<String> intersection;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char t = str1.charAt(i);
            if ((t >= 48 && t <= 57) || (t >= 65 && t <= 90)) {
                s1.add(str1.substring(i, i + 2));
            } else {
                s1.remove(s1.size() - 1);
            }
        }
//        s2 = s1;
        for (int i = 0; i < str2.length() - 1; i++) {
            char t = str2.charAt(i);
            if ((t >= 48 && t <= 57) || (t >= 65 && t <= 90)) {
                s2.add(str2.substring(i, i + 2));
            } else {
                s2.remove(s2.size() - 1);
            }
        }
        System.out.println(s1);
        System.out.println(s2);

        int s1Size = s1.size();
        intersection = s2;

        for (String s : s1) {
            s2.remove(s);
        }
//        System.out.println(s2);
        for (String s : s1) {
            intersection.remove(s);
        }
        System.out.println(intersection);
        answer = intersection.size() * 65536 / (s1Size + s2.size());
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("France", "french"));
        System.out.println();
//        System.out.println(new Solution().solution("aaa", "aaaaa"));
        System.out.println(new Solution().solution("handshake", "shake hands"));
        System.out.println();
        System.out.println(new Solution().solution("aa1+aa2", "AAAA12"));
//        System.out.println((int) '0');
//        System.out.println((int) '9');
//        System.out.println((int) 'A');
//        System.out.println((int) 'Z');
//        System.out.println((int) ' ');
    }
}
