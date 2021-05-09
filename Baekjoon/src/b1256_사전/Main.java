package b1256_사전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> strings;
    static int n;
    static int m;
    static int k;
    static int count;
    static char[] chars;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        strings = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chars = new char[n + m];
        dp = new int[n + 1][m + 1];

        if (comb(n + m, m) < k) {
            System.out.println("-1");
            return;
        }

        combineAZ(0, 0, 0);
    }

    static void combineAZ(int a, int z, int depth) {
        if (depth == n + m) {
            count++;
            System.out.println(chars);
            return;
        }

        if (a < n) {
            chars[depth] = 'a';
            combineAZ(a + 1, z, depth + 1);
        }

        if (z < m) {
            chars[depth] = 'z';
            combineAZ(a, z + 1, depth + 1);
        }
    }

    static long comb(int a, int b) {
        long answer = 1;

        if (b > a / 2) {
            b = a - b;
        }

        for (int i = 0; i < b; i++) {
            answer *= a--;
        }

        for (int i = 0; i < n; i++) {
            answer /= b--;
        }

        return answer;
    }
}