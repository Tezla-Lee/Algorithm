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
        Location end = null;
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;

        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
                if (row[j] == 'S') {
                    start = new Location(i, j);
                    startRow = i;
                    startCol = j;
                } else if (row[j] == 'D') {
                    end = new Location(i, j);
                    endRow = i;
                    endCol = j;
                }
            }
        }

        isVisited[startRow][startCol] = true;
//        dfs(startRow, startCol, endRow, endCol, map, 0);
        bfs(start, end, map);

        if (min == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(min);
        }
    }

    static int r;
    static int c;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isVisited;
    static int min = Integer.MAX_VALUE;

    static void dfs(int startRow, int startCol, int endRow, int endCol, char[][] map, int depth) {

        char[][] temp = new char[r][c];

        for (int i = 0; i < r; i++) {
            temp[i] = map[i].clone();
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if (startRow == endRow && startCol == endCol) {
            min = Math.min(min, depth);
//            System.out.println("통과 : " + depth);
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (map[i][j] == '*') {

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];

                        if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c) {
                            if (map[tempX][tempY] == '.') {
                                temp[tempX][tempY] = '*';
                            }
                        }
                    }
                }
            }
        }

//        temp = water(temp);

        for (int i = 0; i < 4; i++) {
            int tempX = startRow + dx[i];
            int tempY = startCol + dy[i];

            if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c && !isVisited[tempX][tempY] && (temp[tempX][tempY] == '.' || temp[tempX][tempY] == 'D')) {
                isVisited[tempX][tempY] = true;
                temp[tempX][tempY] = 'S';
                temp[startRow][startCol] = '.';
                dfs(tempX, tempY, endRow, endCol, temp, depth + 1);
                isVisited[tempX][tempY] = false;
                temp[tempX][tempY] = '.';
                temp[startRow][startCol] = 'S';
            }
        }
    }

        static void water(char[][] arr) {
//        char[][] temp = new char[r][c];
//
//        for (int i = 0; i < r; i++) {
//            temp[i] = arr[i].clone();
//        }
//
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (arr[i][j] == '*') {

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];

                        if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c) {
                            if (arr[tempX][tempY] == '.') {
                                arr[tempX][tempY] = '*';
                            }
                        }
                    }
                }
            }
        }
//        return temp;
    }


    static Queue<Location> queue = new LinkedList<>();

    static void bfs(Location start, Location end, char[][] map) {

        queue.add(start);
        isVisited[start.row][start.col] = true;

        int count = queue.size();

        while (!queue.isEmpty()) {
            water(map);

            for (int i = 0; i < count; i++) {
                Location curr = queue.poll();

                if (curr.row == end.row && curr.col == end.col) {
                    System.out.println("통과");
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int tempX = curr.row + dx[j];
                    int tempY = curr.col + dy[j];

                    if (tempX >= 0 && tempX < r && tempY >= 0 && tempY < c && !isVisited[tempX][tempY] && (map[tempX][tempY] == '.' || map[tempX][tempY] == 'D')) {
                        isVisited[tempX][tempY] = true;
                        queue.add(new Location(tempX, tempY));
//                    map[tempX][tempY] = 'S';
//                    map[curr.row][curr.col] = '.';
//                    isVisited[tempX][tempY] = false;
//                    map[tempX][tempY] = '.';
//                    map[curr.row][curr.col] = 'S';
                    }
                }
            }
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