package b15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n + 1];
        numbers = new int[m];
        sb = new StringBuilder();

        comb(1, 0);

        System.out.println(sb.toString());
    }

    static int n;
    static int m;
    static boolean[] isVisited;
    static int[] numbers;
    static StringBuilder sb;

    static void comb(int start, int index) {
        if (index == m) {
            for (int n : numbers) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                numbers[index] = i;
                comb(i + 1, index + 1);
                isVisited[i] = false;
            }
        }
    }
}