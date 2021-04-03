package _2021_데.프로그래밍1;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] check = new int[46];
        int count = 0;

        for (int i = 0; i < lottos.length; i++) {
            check[lottos[i]]++;
        }

        for (int i = 0; i < win_nums.length; i++) {
            if (check[win_nums[i]] == 1) {
                count++;
            }
        }

        // 최고 순위
        answer[0] = 7 - (count + check[0]);
        if (answer[0] > 6) {
            answer[0] = 6;
        }

        // 최저 순위
        answer[1] = 7 - count;
        if (answer[1] > 6) {
            answer[1] = 6;
        }


        return answer;
    }
}