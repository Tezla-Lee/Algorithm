package _2019_카카오개발자겨울인텁십.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int[] solution(String s) {
        String[] tupleStrings = s.substring(2, s.length() - 2).split("},\\{");

        List<List<Integer>> elements = new ArrayList<>();
        List<Integer> tuple = new ArrayList<>();

        for (String tupleString : tupleStrings) {
            String[] numbers = tupleString.split(",");
            List<Integer> element = new ArrayList<>();

            for (String number : numbers) {
                element.add(Integer.parseInt(number));
            }

            elements.add(element);
        }

        elements.sort((a, b) -> a.size() - b.size());

        for (List<Integer> list : elements) {
            for (int num : list) {
                if (!tuple.contains(num)) {
                    tuple.add(num);
                }
            }
        }

        int[] answer = new int[tuple.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = tuple.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(new Solution2().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(new Solution2().solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(new Solution2().solution("{{123}}")));
    }
}
