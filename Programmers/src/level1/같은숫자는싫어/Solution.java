package level1.같은숫자는싫어;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answer.add(arr[0]);
            } else {
                if (arr[i] != arr[i - 1]) {
                    answer.add(arr[i]);
                }
            }
        }
        return answer;
    }
}
