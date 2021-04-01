package minimumWindowSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String minWindow(String s, String t) {
        String answer = s;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> check = new HashMap<>();
        List<Character> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (char c : tChars) {
            check.put(c, check.getOrDefault(c, 0) + 1);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < sChars.length; i++) {
            list.add(sChars[i]);
            sb.append(sChars[i]);

            if (tMap.containsKey(sChars[i])) {
                sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);

                if (check.containsKey(sChars[i])) {
                    int count = check.get(sChars[i]);

                    if (count == 1) {
                        check.remove(sChars[i]);
                    } else {
                        check.put(sChars[i], count - 1);
                    }
                }

                if (check.size() == 0) {
                    while (!sMap.containsKey(list.get(0)) || sMap.get(list.get(0)) > tMap.get(list.get(0))) {
                        if (sMap.containsKey(list.get(0))) {
                            sMap.put(list.get(0), sMap.get(list.get(0)) - 1);
                        }

                        list.remove(0);
                        sb.deleteCharAt(0);
                    }

                    if (sb.length() < answer.length()) {
                        answer = sb.toString();
                    }
                }
            }
        }

        if (check.size() != 0) {
            return "";
        }

        while (!tMap.containsKey(list.get(list.size() - 1))) {
            list.remove(list.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() < answer.length()) {
            answer = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("ab", "a"));
        System.out.println(new Solution().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}