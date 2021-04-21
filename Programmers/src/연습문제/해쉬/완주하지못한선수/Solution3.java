package 연습문제.해쉬.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        for (Map.Entry<String, Integer> key : map.entrySet()) {
            if (key.getValue() == 1) {
                return key.getKey();
            }
        }
        return null;
    }
}
