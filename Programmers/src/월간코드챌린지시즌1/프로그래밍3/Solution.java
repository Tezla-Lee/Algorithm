package 월간코드챌린지시즌1.프로그래밍3;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] a) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (isSame(list, i)) {

            }
        }
        return answer;
    }

    public boolean isSame(ArrayList<Integer> arr, int index) {
        return arr.get(index).equals(arr.get(index + 2))
                && arr.get(index + 1).equals(arr.get(index + 3));
    }
}
