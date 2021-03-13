package b1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        isVisited = new boolean[91];
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        isVisited[map[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    static int max;
    static int r;
    static int c;
    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[] isVisited;

    static void dfs(int row, int col, int depth) {
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int nextR = row + dr[i];
            int nextC = col + dc[i];

            if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c) {
                if (!isVisited[map[nextR][nextC]]) {
                    isVisited[map[nextR][nextC]] = true;
                    dfs(nextR, nextC, depth + 1);
                    isVisited[map[nextR][nextC]] = false;
                }
            }
        }
    }
}