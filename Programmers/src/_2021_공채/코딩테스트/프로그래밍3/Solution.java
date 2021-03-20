package _2021_공채.코딩테스트.프로그래밍3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        Queue<Integer> leaveQu = new LinkedList<>();

        for (int l : leave) {
            leaveQu.add(l);
        }

        List<Integer> list = new ArrayList<>();

        for (int e : enter) {

            while (list.contains(leaveQu.peek())) {
                list.remove(leaveQu.poll());
            }

            for (int i : list) {
                answer[i - 1]++;
            }
            answer[e - 1] += list.size();
            list.add(e);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 3, 4})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 2, 1}, new int[]{2, 1, 3})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 2, 1}, new int[]{1, 3, 2})));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
