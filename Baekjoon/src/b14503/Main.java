package b14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        isChecked = new int[row][col];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(x, y, direction);
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.printf("%2d ", isChecked[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(count);
    }

    static int[][] map;
    static int[][] isChecked;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    static void dfs(int x, int y, int direction) {
        if (isChecked[x][y] == 0) {
            count++;
            isChecked[x][y] = count;
        }
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[(direction - i + 3) % 4];
            int tempY = y + dy[(direction - i + 3) % 4];
            if (map[tempX][tempY] == 0 && isChecked[tempX][tempY] == 0) {
                dfs(tempX, tempY, (direction - i + 3) % 4);
                return;
            }
        }
        if (map[x - dx[direction]][y - dy[direction]] == 0) {
            dfs(x - dx[direction], y - dy[direction], direction);
        }
    }
}