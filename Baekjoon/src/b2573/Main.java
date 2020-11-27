package b2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[][] map = new String[n][m];
        String[][] map2 = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }
        int year = 0;
        while (true) {
            year++;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int temp = Integer.parseInt(map[i][j]);
                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];
                        if (!map[i][j].equals("0") && tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
                            if (temp != 0 && map[tempX][tempY].equals("0")) {
                                temp--;
                            }
                        }
                    }
                    map2[i][j] = String.valueOf(temp);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = map2[i][j];
                }
            }
            isVisited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!isVisited[i][j] && !map[i][j].equals("0")) {
                        dfs(map, i, j, 0);
                        count++;
                    }
                }
            }
            if (count >= 2) {
                System.out.println(year);
                break;
            }
            if (count == 0) {
                System.out.println(0);
                break;
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] isVisited;

    public static int dfs(String[][] map, int x, int y, int year) {
        isVisited[x][y] = true;
        int tempX;
        int tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < map.length && tempY < map[0].length) {
                if (!isVisited[tempX][tempY] && !map[tempX][tempY].equals("0")) {
                    dfs(map, tempX, tempY, year + 1);
                }
            }
        }
        return year;
    }
}
