package b15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);
        arr = new int[m];
        visit = new boolean[n];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {
        if (m == depth) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                arr[depth] = i + 1;
                for (int j = 0; j < i; j++) {
                    visit[j] = true;
                }
                dfs(n, m, depth + 1);
                for (int j = 0; j < i; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}