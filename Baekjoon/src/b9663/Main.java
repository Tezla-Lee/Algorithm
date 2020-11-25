package b9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queen = new int[n];
        dfs(0);
        System.out.println(count);
    }

    static int[] queen;
    static int n, count;

    static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queen[depth] = i + 1;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
            queen[depth] = 0;
        }
    }

    static boolean isPossible(int x) {
        for (int i = 0; i < n; i++) {
            if (i != x && queen[i] == queen[x]) {
                return false;
            }
            if (i != x && queen[i] != 0 && Math.abs(i - x) == Math.abs(queen[i] - queen[x])) {
                return false;
            }
        }
        return true;
    }
}