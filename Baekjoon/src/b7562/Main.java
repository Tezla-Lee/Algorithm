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
        StringTokenizer st;
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            int n = Integer.parseInt(br.readLine());
            check = new boolean[n][n];
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
        }
    }

    static boolean[][] check;

    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x1, y1));

        while (!queue.isEmpty()) {

        }

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