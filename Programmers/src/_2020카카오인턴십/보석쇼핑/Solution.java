package _2020카카오인턴십.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        // 보석마다 몇개씩 있는지 파악
        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }
        return search(gems, map);
    }

    static int[] search(String[] gems, Map<String, Integer> map) {
        Map<String, Integer> map2 = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for (int i = 0; i < gems.length; i++) {
            queue.add(gems[i]);
            map2.put(gems[i], map2.getOrDefault(gems[i], 0) + 1);
            end = i;
            if (map.size() == map2.size()) {
                while (map2.get(queue.peek()) > 1) {
                    map2.put(queue.peek(), map2.getOrDefault(queue.poll(), 0) - 1);
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
}