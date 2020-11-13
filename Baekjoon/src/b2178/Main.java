package b2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        maze = new String[n][m];
        check = new int[n][m];

        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().split("");
        }
        bfs(0, 0);
        System.out.println(check[n - 1][m - 1]);
    }

    static String[][] maze;
    static int[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<XY> queue = new LinkedList<>();
        queue.offer(new XY(x, y));
        check[x][y] = 1;
        int tempX, tempY;

        while (!queue.isEmpty()) {
            XY tempXY = queue.poll();
            for (int i = 0; i < 4; i++) {
                tempX = tempXY.x + dx[i];
                tempY = tempXY.y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < maze.length && tempY < maze[0].length) {
                    if (maze[tempX][tempY].equals("1") && check[tempX][tempY] == 0) {
                        queue.offer(new XY(tempX, tempY));
                        check[tempX][tempY] = check[tempXY.x][tempXY.y] + 1;
                    }
                }
            }
        }
    }
}

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
