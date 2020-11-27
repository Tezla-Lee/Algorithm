package b2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] mnk = br.readLine().split(" ");
        int m = Integer.parseInt(mnk[0]);
        int n = Integer.parseInt(mnk[1]);
        int k = Integer.parseInt(mnk[2]);
        int[][] map = new int[n][m];
        int x1, x2, y1, y2;
        ArrayList<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] x1y1x2y2 = br.readLine().split(" ");
            x1 = Integer.parseInt(x1y1x2y2[0]);
            y1 = Integer.parseInt(x1y1x2y2[1]);
            x2 = Integer.parseInt(x1y1x2y2[2]);
            y2 = Integer.parseInt(x1y1x2y2[3]);
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (j >= x1 && j < x2 && l >= y1 && l < y2) {
                        map[j][l] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(map, i, j);
                    areaList.add(count);
                }
            }
        }
        Collections.sort(areaList);
        sb.append(areaList.size()).append("\n");
        for (int i : areaList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    static void dfs(int[][] map, int x, int y) {
        map[x][y] = 2;
        int tempX;
        int tempY;
        count++;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < map.length
                    && tempY >= 0 && tempY < map[0].length) {
                if ((map[tempX][tempY]) == 0) {
                    dfs(map, tempX, tempY);
                }
            }
        }
    }
}
