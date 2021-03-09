package level2._메뉴리뉴얼;

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        String[] answer = new String[5];

        Arrays.sort(orders);

        for (String order : orders) {
            for (int i = 2; i <= order.length(); i++) {
                addCourse(order, 0, 0, new char[i]);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                if (answer[entry.getKey().length()] == null) {
                    answer[entry.getKey().length()] = entry.getKey();
                } else if (map.get(answer[entry.getKey().length()]) < entry.getValue()) {
                    answer[entry.getKey().length()] = entry.getKey();
                }
            }
        }

        return answer;
    }

    static HashMap<String, Integer> map;

    static void addCourse(String order, int depth, int index, char[] comb) {
        if (depth == comb.length) {
            StringBuilder course = new StringBuilder();
            for (char c : comb) {
                course.append(c);
            }
            map.put(course.toString(), map.getOrDefault(course.toString(), 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            comb[depth] = order.charAt(i);
            addCourse(order, depth + 1, i + 1, comb);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }
}