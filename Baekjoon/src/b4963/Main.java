package b4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] wh;
        while (true) {
            wh = br.readLine().split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);
            int count = 0;
            if (w == 0 && h == 0) {
                break;
            } else {
                String[][] map = new String[h][w];
                for (int i = 0; i < h; i++) {
                    map[i] = br.readLine().split(" ");
                }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (map[i][j].equals("1")) {
                            dfs(map, i, j);
                            count++;
                        }
                    }
                }
                sb.append(count).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int[] dx = new int[]{1, 0, 1, -1, 0, -1, 1, -1};
    static int[] dy = new int[]{0, 1, 1, 0, -1, -1, -1, 1};

    public static void dfs(String[][] map, int x, int y) {
        map[x][y] = "0";
        int tempX;
        int tempY;
        for (int i = 0; i < 8; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < map.length
                    && tempY >= 0 && tempY < map[0].length) {
                if (map[tempX][tempY].equals("1")) {
                    dfs(map, tempX, tempY);
                }
            }
        }
    }
}
