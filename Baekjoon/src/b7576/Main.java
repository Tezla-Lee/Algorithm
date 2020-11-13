package b7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[n][m];
        move = new int[n][m];
        int maxDay = Integer.MIN_VALUE;
        if (!existZero(box)) {
            System.out.println(0);
        } else {
            bfs();
//            for (int k = 0; k < n; k++) {
//                for (int l = 0; l < m; l++) {
//                    System.out.print(move[k][l] + " ");
//                }
//                System.out.println();
//            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maxDay = Math.max(move[i][j], maxDay);
                }
            }
            if (count != count2) {
                System.out.println(-1);
            } else {
                System.out.println(maxDay);
            }
        }
    }

    static int[][] box;
    static int[][] move;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static int count;
    static int count2;

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
                if ((box[i][j]) == 0) {
                    count++;
                }
            }
        }
        Point temp;
        int tempX, tempY;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                tempX = temp.x + dx[i];
                tempY = temp.y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < box.length && tempY < box[0].length) {
                    if (box[tempX][tempY] == 0 && move[tempX][tempY] == 0) {
                        count2++;
                        move[tempX][tempY] = move[temp.x][temp.y] + 1;
                        queue.offer(new Point(tempX, tempY));
                    }
                }
            }
        }
    }

    static boolean existZero(int[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
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