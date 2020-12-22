package b3055_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        isVisited = new boolean[r][c];

        Location start = null;

        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
                if (row[j] == 'S') {
                    start = new Location(i, j);
                    isVisited[i][j] = true;
                }
            }
        }

        bfs(start, map);

        if (flag) {
            System.out.println(count);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static int r;
    static int c;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isVisited;


    static int count = 0;
    static boolean flag;

    static void bfs(Location start, char[][] map) {
        Queue<Location> queue = new LinkedList<>();
        Queue<Location> queue2 = new LinkedList<>();

        queue.add(start);
        isVisited[start.row][start.col] = true;


        do {
            count++;
            water(map);

            while (!queue2.isEmpty()) {
                queue.add(queue2.poll());
            }

            while (!queue.isEmpty()) {

                Location curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int tempX = curr.row + dx[i];
                    int tempY = curr.col + dy[i];

                    if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c && !isVisited[tempX][tempY]) {
                        if (map[tempX][tempY] == '.') {
                            isVisited[tempX][tempY] = true;
                            queue2.add(new Location(tempX, tempY));
//                            map[tempX][tempY] = 'S';
                        } else if (map[tempX][tempY] == 'D') {
                            flag = true;
                            return;
                        }
                    }
                }
            }

        } while (!queue2.isEmpty());

    }
    static void water(char[][] arr) {
        char[][] temp = new char[r][c];

        for (int i = 0; i < r; i++) {
            temp[i] = arr[i].clone();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (arr[i][j] == '*') {

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];

                        if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c) {
                            if (arr[tempX][tempY] == '.' || arr[tempX][tempY] == 'S') {
                                temp[tempX][tempY] = '*';
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            arr[i] = temp[i].clone();
        }
    }

}

class Location {
    int row;
    int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}