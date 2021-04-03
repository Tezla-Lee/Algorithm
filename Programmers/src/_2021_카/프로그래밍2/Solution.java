package _2021_카.프로그래밍2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<boolean[]> list;
    boolean[] isUsed;
    boolean[] robots;
    int num;

    public int solution(int[][] needs, int r) {
        list = new ArrayList<>();
        robots = new boolean[needs[0].length];
        num = needs[0].length;
        isUsed = new boolean[num];
        int max = Integer.MIN_VALUE;

        combination(0, 0, r);

        int[] check = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            loop:
            for (int i = 0; i < needs.length; i++) {
                for (int j = 0; j < needs[i].length; j++) {
                    if (needs[i][j] == 1 && !list.get(k)[j]) {
                        continue loop;
                    }
                }
                check[k]++;
                max = Math.max(max, check[k]);
            }
        }

        return max;
    }

    // 로봇 조합
    public void combination(int depth, int start, int r) {
        if (depth == r) {
            list.add(robots.clone());
            return;
        }

        for (int i = start; i < num; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                robots[i] = true;
                combination(depth + 1, i + 1, r);
                robots[i] = false;
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2));
    }
}