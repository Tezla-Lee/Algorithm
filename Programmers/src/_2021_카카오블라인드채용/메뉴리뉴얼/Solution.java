package _2021_카카오블라인드채용.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private HashMap<String, Integer> courses;
    private char[] splitOrder;

    public String[] solution(String[] orders, int[] course) {
        courses = new HashMap<>();

        for (String order : orders) {
            char[] orderSplit = order.toCharArray();
            Arrays.sort(orderSplit);

            for (int size : course) {
                if (size > order.length()) {
                    continue;
                }
                splitOrder = new char[size];
                addCourse(orderSplit, size, 0, 0);
            }
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }

        list.sort((a, b) -> courses.get(b) - courses.get(a));

        List<String> answer = new ArrayList<>();

        for (int size : course) {
            int max = Integer.MIN_VALUE;
            for (String s : list) {
                if (s.length() == size && courses.get(s) >= max) {
                    answer.add(s);
                    max = courses.get(s);
                }
            }
        }

        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    public void addCourse(char[] menus, int size, int depth, int start) {
        if (depth == size) {
            String course = String.valueOf(splitOrder);
            courses.put(course, courses.getOrDefault(course, 0) + 1);
            return;
        }

        for (int i = start; i < menus.length; i++) {
            splitOrder[depth] = menus[i];
            addCourse(menus, size, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}))); // WX XY
    }
}