package _2018카카오블라인드채용._1차_비밀지도;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binaryArr = new String[n];
        for (int i = 0; i < n; i++) {
            binaryArr[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder map = new StringBuilder();
            if (binaryArr[i].length() < n) {
//                map.append(" ".repeat(n - binaryArr[i].length()));
            }
            for (int j = 0; j < binaryArr[i].length(); j++) {
                if (binaryArr[i].charAt(j) == '0') {
                    map.append(" ");
                } else {
                    map.append("#");
                }
            }
            answer[i] = map.toString();
        }
        return answer;
    }
}
