package b2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count;
        String[][] map = new String[n][n];
        boolean[][] isVisited;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }
        int max = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, Integer.parseInt(map[i][j]));
            }
        }
        System.out.println(max);
        for (int i = 0; i <= max; i++) {
            isVisited = new boolean[n][n];
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (Integer.parseInt(map[j][k]) > i && !isVisited[j][k]) {
                        dfs(map, j, k, i, isVisited);
                        count++;
                    }
                }
            }
            System.out.println(i + ": " + count);
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(String[][] map, int x, int y, int rain, boolean[][] isV) {
        isV[x][y] = true;
        int tempX;
        int tempY;
        int n = map.length;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < n
                    && tempY >= 0 && tempY < n) {
                if (!isV[tempX][tempY] && Integer.parseInt(map[tempX][tempY]) > rain) {
                    dfs(map, tempX, tempY, rain, isV);
                }
            }
        }
    }
}