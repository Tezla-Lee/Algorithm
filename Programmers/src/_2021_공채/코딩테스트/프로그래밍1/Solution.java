package _2021_공채.코딩테스트.프로그래밍1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, HashMap<String, Integer>> maps = new HashMap<>();

        for (int i = 0; i < table.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String[] lang = table[i].split(" ");

            for (int j = 1; j < lang.length; j++) {
                map.put(lang[j], lang.length - j);
            }

            maps.put(lang[0], map);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return a.name.compareTo(b.name);
            }

            return b.score - a.score;
        });

        for (Map.Entry<String, HashMap<String, Integer>> entry : maps.entrySet()) {
            HashMap<String, Integer> map = entry.getValue();
            int score = 0;

            for (int i = 0; i < languages.length; i++) {
                score += map.getOrDefault(languages[i], 0) * preference[i];
            }

            pq.add(new Point(entry.getKey(), score));
        }

        return pq.poll().name;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
        System.out.println(new Solution().solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[]{"JAVA", "JAVASCRIPT"}, new int[]{7, 5}));
    }
}

class Point {
    String name;
    int score;

    public Point(String name, int score) {
        this.name = name;
        this.score = score;
    }
}