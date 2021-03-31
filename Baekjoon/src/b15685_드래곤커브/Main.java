 package b15685_드래곤커브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Point> totalPoints;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalPoints = new ArrayList<>();
        board = new boolean[101][101];

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x, y, d, g);
        }

        for (Point point : totalPoints) {
            board[point.getX()][point.getY()] = true;
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dragonCurve(int x, int y, int d, int g) {
        List<Point> points = new ArrayList<>();

        Point center = new Point(x, y);
        Point lastPoint = new Point(x + dx[d], y + dy[d]);
        points.add(center);
        points.add(lastPoint);

        while (g-- > 0) {
            List<Point> temp = new ArrayList<>();

            for (Point point : points) {
                Point rotate = rotateAndMove(point, lastPoint);
                if (rotate.getX() >= 0 && rotate.getX() <= 100 && rotate.getY() >= 0 && rotate.getY() <= 100) {
                    temp.add(rotate);
                }
            }

            lastPoint = temp.get(0);
            points.addAll(temp);
        }

        totalPoints.addAll(points);
    }

    static Point rotateAndMove(Point point, Point center) {
        int x = point.getX() - center.getX();
        int y = point.getY() - center.getY();

        return new Point(-y + center.getX(), x + center.getY());
    }
}

class Point {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}
