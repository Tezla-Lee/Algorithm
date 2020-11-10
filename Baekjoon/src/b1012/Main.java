package b1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            String[] gardenInfo = br.readLine().split(" ");
            int m = Integer.parseInt(gardenInfo[0]);
            int n = Integer.parseInt(gardenInfo[1]);
            int cabbageNum = Integer.parseInt(gardenInfo[2]);
            int count = 0;
            boolean[][] garden = new boolean[m][n];
            String[] xy;
            for (int j = 0; j < cabbageNum; j++) {
                xy = br.readLine().split(" ");
                garden[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = true;
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (garden[j][k]) {
                        dfs(garden, j, k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void dfs(boolean[][] garden, int x, int y) {
        garden[x][y] = false;
        int tempX;
        int tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < garden.length && tempY >= 0 && tempY < garden[0].length) {
                if (garden[tempX][tempY]) {
                    dfs(garden, tempX, tempY);
                }
            }
        }
    }
}
