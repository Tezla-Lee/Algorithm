package b15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review {
    static int[] arr;
    static boolean[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        numbers = new boolean[n];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int k) {
        if (k == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!numbers[i]) {
                arr[k] = i + 1;
                numbers[i] = true;
                dfs(n, m, k + 1);
                numbers[i] = false;
            }
        }
    }
}
