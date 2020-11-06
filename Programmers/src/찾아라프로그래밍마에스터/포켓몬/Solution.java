package 찾아라프로그래밍마에스터.포켓몬;

import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> pocketMon = new HashSet<>();
        for (int num : nums) {
            pocketMon.add(num);
        }
        return Math.min(pocketMon.size(), nums.length / 2);
    }
}
