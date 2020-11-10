package _2018카카오블라인드채용._1차_뉴스클러스터링;

import java.util.ArrayList;

public class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        ArrayList<String> intersection;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String strTemp;
        for (int i = 0; i < str1.length() - 1; i++) {
            strTemp = str1.substring(i, i + 2);
            String[] temp = strTemp.split("");
            if (temp[0].charAt(0) >= 65 && temp[0].charAt(0) <= 90 &&
                    temp[1].charAt(0) >= 65 && temp[1].charAt(0) <= 90) {
                s1.add(strTemp);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            strTemp = str2.substring(i, i + 2);
            String[] temp = strTemp.split("");
            if (temp[0].charAt(0) >= 65 && temp[0].charAt(0) <= 90 &&
                    temp[1].charAt(0) >= 65 && temp[1].charAt(0) <= 90) {
                s2.add(strTemp);
            }
        }
        int s1Size = s1.size();
        intersection = (ArrayList<String>) s2.clone();

        for (
                String s : s1) {
            s2.remove(s);
        }
        for (
                String s : s2) {
            intersection.remove(s);
        }

        if (s1Size + s2.size() == 0) {
            return 65536;
        }
        return intersection.size() * 65536 / (s1Size + s2.size());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("France", "french"));
        System.out.println();
//        System.out.println(new Solution().solution("aaa", "aaaaa"));
        System.out.println(new Solution().solution("handshake", "shake hands"));
        System.out.println();
        System.out.println(new Solution().solution("aa1+aa2", "AAAA12"));
        System.out.println();
        System.out.println(new Solution().solution("E=M*C^2", "e=m*c^2"));
    }
}
