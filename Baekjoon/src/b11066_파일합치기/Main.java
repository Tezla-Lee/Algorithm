package b11066_파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] fileSizes = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            for (int j = 1; j < n + 1; j++) {
                fileSizes[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static int merge(int[][] dp, int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }

        if (start + 1 == end) {
            return arr[start] + arr[end];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {

            }
        }

        return -1;
    }
}