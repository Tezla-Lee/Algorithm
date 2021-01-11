package b12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        int[][] dp = new int[k + 1][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
            max = Math.max(max, v);
        }

        System.out.println(solution(arr, dp, k));
    }

    static long max = Long.MIN_VALUE;

    static long solution(int[][] arr, int[][] dp, int k) {
        for (int i = 0; i < arr.length; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
//            dp[w] = v;

            for (int j = 1; j < dp.length; j++) {

            }
        }
        return max;
    }
}

class thing {
    int weight;
    int value;

    public thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}