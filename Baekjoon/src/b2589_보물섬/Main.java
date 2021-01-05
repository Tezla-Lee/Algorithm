package b2589_보물섬;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    max = Math.max(bfs(map, i, j), max);
                }
            }
        }
        System.out.println(max);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int bfs(char[][] map, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        int[][] d = new int[map.length][map[0].length];
        int max = Integer.MIN_VALUE;

        queue.add(new int[]{row, col});
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tempRow = temp[0] + dx[i];
                int tempCol = temp[1] + dy[i];

                if (tempRow >= 0 && tempCol >= 0 && tempRow < map.length && tempCol < map[0].length) {
                    if (map[tempRow][tempCol] == 'L' && !isVisited[tempRow][tempCol]) {
                        isVisited[tempRow][tempCol] = true;
                        queue.add(new int[]{tempRow, tempCol});
                        d[tempRow][tempCol] = d[temp[0]][temp[1]] + 1;
                        max = Math.max(max, d[tempRow][tempCol]);
                    }
                }
            }
        }
        return max;
    }
}