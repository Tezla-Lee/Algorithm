package _2018_카카오블라인드채용._1차_캐시;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        Queue<String> cache = new LinkedList<>();
        String city;
        for (int i = 0; i < cities.length; i++) {
            city = cities[i];
            if (cache.contains(city)) {
                cache.offer(city);
                answer++;
                if (i > cacheSize - 1) {
                    cache.remove(city);
                }
            } else {
                cache.offer(city);
                answer += 5;
                if (i > cacheSize - 1) {
                    cache.poll();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Panyo", "Seoul", "NewYork", "LA"}));
        System.out.println(new Solution().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(new Solution().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(new Solution().solution(1, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "LA"}));
        System.out.println(new Solution().solution(3, new String[]{"Seoul", "Seoul", "Seoul"}));
    }
}
