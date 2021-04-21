package 연습문제.그래프.순위;

import java.util.Arrays;

class Solution {
    static final int INF = 100000000;

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] fw = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(fw[i], INF);
        }

        for (int[] result : results) {
            fw[result[0]][result[1]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (fw[j][i] + fw[i][k] < fw[j][k]) {
                        fw[j][k] = fw[j][i] + fw[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%d ", fw[i][j]);
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
}