package b7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            int n = Integer.parseInt(br.readLine());
            check = new int[n][n];
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2 && y1 == y2) {
//                System.out.println(0);
                sb.append(0).append("\n");
            } else {
//                System.out.println(bfs(x1, y1, x2, y2));
                sb.append(bfs(x1, y1, x2, y2)).append("\n");
            }
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    System.out.print(check[j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        System.out.println(sb);
    }

    static int[][] check;
    static int dx[] = {2, 2, 1, 1, -1, -1, -2, -2};
    static int dy[] = {1, -1, 2, -2, 2, -2, 1, -1};

    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x1, y1));
        check[x1][y1] = 0;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            if (temp.x == x2 && temp.y == y2) {
                return check[temp.x][temp.y];
            }
            for (int i = 0; i < 8; i++) {
                int tempX = temp.x + dx[i];
                int tempY = temp.y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < check.length && tempY < check.length) {
                    if (check[tempX][tempY] == 0 || check[tempX][tempY] > check[temp.x][temp.y] + 1) {
                        queue.offer(new Point(tempX, tempY));
                        check[tempX][tempY] = check[temp.x][temp.y] + 1;
                    }
                }
            }
        }
        return check[x2][y2];
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}