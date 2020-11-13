package _2018카카오블라인드채용._3차_압축;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(String msg) {
        ArrayList<String> dictionary = new ArrayList<>();
        ArrayList<Integer> lzw = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf((char) (i + 65)));
        }
        for (int i = 0; i < msg.length(); ) {
            if (dictionary.contains(msg.substring(i, i + 1))) {
                int end = 1;
                while (i + end != msg.length() + 1 && dictionary.contains(msg.substring(i, i + end))) {
                    end++;
                }
//                System.out.print(msg.substring(i, i + end - 1) + ", ");
                if (i + end <= msg.length()) {
//                    System.out.print(msg.substring(i, i + end) + " ");
                    dictionary.add(msg.substring(i, i + end));
                }
                lzw.add(dictionary.indexOf(msg.substring(i, i + end - 1)) + 1);
                i += end - 1;
//                System.out.println(i);
                if (i == msg.length() - 1) {
                    lzw.add(dictionary.indexOf(msg.substring(i)) + 1);
                    break;
                }
            }
        }
        int[] answer = new int[lzw.size()];
        for (int i = 0; i < lzw.size(); i++) {
            answer[i] = lzw.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("KAKAO")));
        System.out.println(Arrays.toString(new Solution().solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}