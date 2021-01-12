package _2019_카카오블라인드채용.실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] clearNum = new int[N];
        for (int i : stages) {
            if (i > N) {
                continue;
            }
            clearNum[i - 1]++;
        }
        ArrayList<Failure> failureArrayList = new ArrayList<>();
        int index = stages.length;

        for (int i = 0; i < clearNum.length; i++) {
            if (index == 0) {
                failureArrayList.add(new Failure(0, i + 1));
            } else {
                failureArrayList.add(new Failure((float) clearNum[i] / index, i + 1));
            }
            index -= clearNum[i];
        }

        Collections.sort(failureArrayList, (a, b) -> {
            if (Float.compare(b.fail, a.fail) == 0) {
                return a.stage - b.stage;
            }
            return Float.compare(b.fail, a.fail);
        });

        for (int i = 0; i < failureArrayList.size(); i++) {
            answer[i] = failureArrayList.get(i).stage;
        }
        System.out.println(Arrays.toString(clearNum));
        System.out.println(failureArrayList);
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(new Solution().solution(4, new int[]{4, 4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(new Solution().solution(10, new int[]{4, 4, 4, 4, 4, 4})));
//        System.out.println(Arrays.toString(new Solution().solution(2, new int[]{1, 2, 1, 2, 1})));
    }

    public static class Failure {
        float fail;
        int stage;

        public Failure(float fail, int stage) {
            this.fail = fail;
            this.stage = stage;
        }

        @Override
        public String toString() {
            return stage + "," + fail;
        }
    }
}
