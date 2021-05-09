package _2017_카카오코드본선.GPS;

import java.util.Arrays;

class Solution {
    static int answer;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        answer = Integer.MAX_VALUE;
        boolean[][] edges = new boolean[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            edges[i][i] = true;
        }

        for (int[] edge : edge_list) {
            edges[edge[0]][edge[1]] = true;
            edges[edge[1]][edge[0]] = true;
        }

        changePath(gps_log, edges, 0, n, 0);

        return answer;
    }

    void changePath(int[] gps_log, boolean[][] edges, int t, int n, int count) {
        int[] temp = gps_log.clone();
        System.out.println(Arrays.toString(temp));

        for (int i = t; i < gps_log.length - 1; i++) {
            if (!edges[gps_log[i]][gps_log[i + 1]]) {
                for (int j = 1; j < n + 1; j++) {
                    if (edges[gps_log[i - 1]][j]) {
                        temp[i] = j;
                        changePath(temp, edges, i, n, count + 1);
                    }
                }
            }
        }

        answer = Math.min(answer, count);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5},
                {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 3, 3, 6, 7}));
    }
}