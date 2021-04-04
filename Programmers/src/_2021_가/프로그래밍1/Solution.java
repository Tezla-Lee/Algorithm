package _2021_가.프로그래밍1;

class Solution {
    public int solution(String s) {
        char[] chars = s.toCharArray();
        char prev = 0; // 이전의 a 또는 z 저장
        int count = 0; // a, z 가 번갈아 나오는 횟수 저장

        for (char c : chars) {
            if (c == 'a' || c == 'z') {
                if (prev != 0 && prev != c) { // prev 가 초기값이 아니고 현재 값과 다르면 count + 1
                    count++;
                }
                prev = c; // prev 최신화
            }
        }
        return count;
    }
}
