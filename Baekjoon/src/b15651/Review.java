package b15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review {
    static int n, m;
    static boolean[] isUsed;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isUsed = new boolean[n];
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int k, int start) {
        if (k == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            if (!isUsed[i]) {
                arr[k] = i + 1;
                dfs(k + 1, start);
            }
        }
    }
}