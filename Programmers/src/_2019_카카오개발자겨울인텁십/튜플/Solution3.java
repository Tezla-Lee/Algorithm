package _2019_카카오개발자겨울인텁십.튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int[] solution(String s) {
        String[] elementStrings = s.substring(2, s.length() - 2).split("},\\{");

        Arrays.sort(elementStrings, (a, b) -> a.length() - b.length()); // 원소 개수 적은 순으로

        int[] answer = new int[elementStrings[elementStrings.length - 1].split(",").length]; // 원소 제일 많은 개수로 초기화
        Set<Integer> set = new HashSet<>();

        int index = 0;
        for (String element : elementStrings) {
            String[] numbers = element.split(",");

            for (String number : numbers) {
                int num = Integer.parseInt(number);

                if (!set.contains(num)) {
                    set.add(num);
                    answer[index++] = num;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(new Solution3().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(new Solution3().solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(new Solution3().solution("{{123}}")));
    }
}
