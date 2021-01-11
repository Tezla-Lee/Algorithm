package _2020카카오인턴십.보석쇼핑;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }
        return search(gems, map);
    }

    static int[] search(String[] gems, Map<String, Integer> map) {
        Map<String, Integer> map2 = new HashMap<>();

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for (int i = 0; i < gems.length; i++) {
            map2.put(gems[i], map2.getOrDefault(gems[i], 0) + 1);
            end = i;
            if (map.size() == map2.size()) {
                while (map2.get(gems[start]) > 1) {
                    map2.put(gems[start], map2.getOrDefault(gems[start], 0) - 1);
                    start++;
                }
                if (end - start < minLength) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                    minLength = Math.min(minLength, end - start);
                }
            }
        }
        return answer;
    }
}