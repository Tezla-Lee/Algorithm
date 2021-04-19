package _2019_카카오개발자겨울인텁십.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public int[] solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == ',' || i == chars.length - 2) {
                int num = Integer.parseInt(sb.toString());
                if (!set.contains(num)) {
                    set.add(num);
                    list.add(num);
                }
                sb = new StringBuilder();
            }
            if (Character.isDigit(chars[i])) {
                sb.append(chars[i]);
            }
        }
        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
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
