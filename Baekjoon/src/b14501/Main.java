package b14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T = new int[n];
        P = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        isChecked = new boolean[n];
        dfs(0, 0);
        System.out.println(max);
    }

    static int n;
    static int price;
    static int max = 0;
    static boolean[] isChecked;

    static void dfs(int day, int depth) {
        if (depth == 0) {
            price = 0;
        }
        if (day >= n) {
            max = Math.max(max, price);
        }

        for (int i = day; i < n; i++) {
            if (!isChecked[i]) {
                if (i + T[i] - 1 < n) {
                    isChecked[i] = true;
                    price += P[i];
                    dfs(i + T[i], depth + 1);
                    price -= P[i];
                    isChecked[i] = false;
                } else {
                    max = Math.max(max, price);
                }
            }
        }
    }
    static int[] T;
    static int[] P;
}