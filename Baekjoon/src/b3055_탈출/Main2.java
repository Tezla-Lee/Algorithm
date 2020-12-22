package b3055_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실패
public class Main2 {

    static int r;
    static int c;
    static int count = -1;
    static boolean[][] isVisited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        isVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
                if (row[j] == 'S' || row[j] == '*') {
                    isVisited[i][j] = true;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        bfs();

        if (count == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(count);
        }
    }

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    System.out.printf("%2c", map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                if (nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c) {
                    // 현재 위치가 고슴도치
                    if (map[curRow][curCol] == 'S' || cur[2] > 0) {
                        // 비버 굴
                        if (map[nextRow][nextCol] == 'D') {
                            count = cur[2] + 1;
                            return;
                        }
                        // 빈칸이고 방문 X
                        if (map[nextRow][nextCol] == '.' && !isVisited[nextRow][nextCol]) {
                            isVisited[nextRow][nextCol] = true;
                            map[nextRow][nextCol] = 'S';
                            queue.offer(new int[]{nextRow, nextCol, cur[2] + 1});
                        }

                        // 현재 위치가 물
                    } else if (map[curRow][curCol] == '*') {
                        // 고슴도치면
                        if (map[nextRow][nextCol] == 'S') {
                            map[nextRow][nextCol] = '*';
                            isVisited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol, 0});
                            // 벽, 비버 굴이 아니고 방문 X
                        }
                        if (map[nextRow][nextCol] != 'D' && map[nextRow][nextCol] != 'X' && !isVisited[nextRow][nextCol]) {
                            map[nextRow][nextCol] = '*';
                            isVisited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol, 0});

                        }
                    }
                }
            }
        }
    }
}