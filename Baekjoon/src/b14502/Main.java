package b14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isGone = new boolean[n][m];
        int roomSize = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    roomSize++;
                }
                map[i][j] = temp;
            }
        }


        createWall(0);

        System.out.println(roomSize - min - 3);
    }

    static int n, m;
    static int[][] map;
    static boolean[][] isGone;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count;
    static int min = Integer.MAX_VALUE;

    static void dfs(int x, int y) {
        if (map[x][y] != 2) {
            count++;
        }
        isGone[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
                if (!isGone[tempX][tempY] && map[tempX][tempY] == 0) {
                    dfs(tempX, tempY);
                }
            }
        }
    }

    static void createWall(int depth) {
        if (depth == 3) {
            count = 0;
            isGone = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!isGone[i][j] && map[i][j] == 2) {
                        dfs(i, j);
                    }
                }
            }
            min = Math.min(min, count);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    createWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}