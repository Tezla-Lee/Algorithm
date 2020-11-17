package b3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        Point start = new Point(0, 0);
        Point move = new Point(1, 0);
        List<Point> snake = new ArrayList<>();
        List<Point> apple = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] xy = br.readLine().split(" ");
            apple.add(new Point(Integer.parseInt(xy[1]) - 1, Integer.parseInt(xy[0]) - 1));
        }
        int count = 0;
        int l = Integer.parseInt(br.readLine());
        int temp = 0;
        boolean flag = false;
        snake.add(new Point(0, 0));
        loop:
        for (int i = 0; i < l; i++) {
            String[] moveInfo = br.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(moveInfo[0]) - temp; j++) {
                start.x += move.x;
                start.y += move.y;
                Point newPoint = new Point(start.x, start.y);
                count++;
                // 벽에 부딪히는지
                if (newPoint.x < 0 || newPoint.y < 0 || newPoint.x == n || newPoint.y == n) {
                    flag = true;
                    break loop;
                }
                // 뱀 자신에게
                for (int m = 0; m < snake.size(); m++) {
                    if (snake.get(m).x == newPoint.x && snake.get(m).y == newPoint.y) {
                        flag = true;
                        break loop;
                    }
                }
                snake.add(newPoint);
                boolean flag2 = false;
                // 사과 먹음
                for (int m = 0; m < apple.size(); m++) {
                    if (apple.get(m).x == newPoint.x && apple.get(m).y == newPoint.y) {
                        apple.remove(m);
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) {
                    snake.remove(0);
                }
            }

            int tempX = move.x;
            int tempY = move.y;
            if (moveInfo[1].equals("D")) {
                if (tempX != 0) {
                    move.x = 0;
                } else {
                    if (tempY == 1) {
                        move.x = -1;
                    } else {
                        move.x = 1;
                    }
                }
                if (tempY != 0) {
                    move.y = 0;
                } else {
                    if (tempX == 1) {
                        move.y = 1;
                    } else {
                        move.y = -1;
                    }
                }
            } else if (moveInfo[1].equals("L")) {
                if (tempX != 0) {
                    move.x = 0;
                } else {
                    if (tempY == 1) {
                        move.x = 1;
                    } else {
                        move.x = -1;
                    }
                }
                if (tempY != 0) {
                    move.y = 0;
                } else {
                    if (tempX == 1) {
                        move.y = -1;
                    } else {
                        move.y = 1;
                    }
                }
            }
            temp = Integer.parseInt(moveInfo[0]);
        }
        while (!flag) {
            boolean flag2 = false;
            start.x += move.x;
            start.y += move.y;
            Point newPoint = new Point(start.x, start.y);
            count++;
            if (start.x < 0 || start.y < 0 || start.x == n || start.y == n) {
                break;
            }
            // 뱀 자신에게
            for (int m = 0; m < snake.size(); m++) {
                if (snake.get(m).x == newPoint.x && snake.get(m).y == newPoint.y) {
                    flag = true;
                    break;
                }
            }
            snake.add(newPoint);
            // 사과
            for (int m = 0; m < apple.size(); m++) {
                if (apple.get(m).x == newPoint.x && apple.get(m).y == newPoint.y) {
                    apple.remove(m);
                    flag2 = true;
                    break;
                }
            }
            if (!flag2) {
                snake.remove(0);
            }
        }
        System.out.println(count);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}