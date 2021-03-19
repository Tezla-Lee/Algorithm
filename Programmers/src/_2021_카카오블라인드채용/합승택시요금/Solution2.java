package _2021_카카오블라인드채용.합승택시요금;

import java.util.*;

class Solution2 {
    static int[][] d;
    static final int INF = 20000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }


        for (int[] fare : fares) {
            d[fare[0]][fare[1]] = fare[2];
            d[fare[1]][fare[0]] = fare[2];
        }

        floydWarshall(n);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(d[s][i] + d[i][a] + d[i][b], answer);
        }

        return answer;
    }

    static void floydWarshall(int n) {
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
