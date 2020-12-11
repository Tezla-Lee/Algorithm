package b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            numbers = new int[n];
            arr = new int[6];
            isUsed = new boolean[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static boolean[] isUsed;
    static int[] arr;

    static void dfs(int index, int depth) {
        if (depth == 6) {
            for (int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = numbers[i];
                dfs(i, depth + 1);
                isUsed[i] = false;
            }
        }
    }
}