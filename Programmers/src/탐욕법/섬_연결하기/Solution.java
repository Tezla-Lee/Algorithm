package 탐욕법.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 비용 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


        return answer;
    }

    static int getParent(int[] parent) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}