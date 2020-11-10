package b2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] num1num2 = br.readLine().split(" ");
        int num1 = Integer.parseInt(num1num2[0]);
        int num2 = Integer.parseInt(num1num2[1]);
        boolean[] isVisited = new boolean[n + 1];
        int[][] relationship = new int[n + 1][n + 1];
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String[] v = br.readLine().split(" ");
            relationship[Integer.parseInt(v[0])][Integer.parseInt(v[1])] = 1;
            relationship[Integer.parseInt(v[1])][Integer.parseInt(v[0])] = 1;
        }
        dfs(num1, num2, relationship, isVisited, 0);
        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    static int count = Integer.MAX_VALUE;

    public static void dfs(int start, int end, int[][] relationship, boolean[] isVisited, int depth) {
        isVisited[start] = true;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i] && relationship[start][i] == 1) {
                if (i == end) {
                    count = Math.min(count, depth + 1);
                    break;
                } else {
                    dfs(i, end, relationship, isVisited, depth + 1);
                }
            }
        }
        isVisited[start] = false;
    }
}
