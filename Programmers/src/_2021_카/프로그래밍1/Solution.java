package _2021_카.프로그래밍1;

public class Solution {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int[] count = new int[100001];

        for (int card : gift_cards) {
            count[card]++;
        }

        for (int want : wants) {
            if (count[want] > 0) {
                count[want]--;
            } else {
                answer++;
            }
        }

        return answer;
    }
}