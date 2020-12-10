package b2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1][2];

        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        bfs();
    }

    static int n, m;
    static int[][] map;
    static int[][] dp;
    static boolean[][][] isVisited;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1, 0, 1));
        isVisited[1][1][0] = true;
        dp[1][1] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == n && point.y == m) {
                System.out.println(point.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];

                if (tempX > 0 && tempY > 0 && tempX < n + 1 && tempY < m + 1) {
                    // 빈 공간
                    if (map[tempX][tempY] == 0) {
                        if (!isVisited[tempX][tempY][point.breakWall]) {
                            isVisited[tempX][tempY][point.breakWall] = true;
                            queue.add(new Point(tempX, tempY, point.breakWall, point.count + 1));
                        }
                    } else { // 벽
                        if (point.breakWall == 0 && !isVisited[tempX][tempY][1]) { // 벽 부신적 있는지 확인
                            queue.add(new Point(tempX, tempY, 1, point.count + 1));
                            isVisited[tempX][tempY][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}

class Point {
    int x;
    int y;
    int breakWall;
    int count;

    public Point(int x, int y, int breakWall, int count) {
        this.x = x;
        this.y = y;
        this.breakWall = breakWall;
        this.count = count;
    }
}