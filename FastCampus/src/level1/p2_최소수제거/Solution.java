package level1.p2_최소수제거;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
            arrayList.add(arr[i]);
        }

        arrayList.remove(minIndex);

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        if (answer.length == 0) {
            return new int[]{-1};
        }

        return answer;
    }
}