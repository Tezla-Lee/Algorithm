package b2234_성곽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        isVisited = new boolean[m][n];
        roomSizes = new int[m * n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomNumber = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j, roomNumber);
                    roomSizes[roomNumber++] = roomSize;
                    maxRoomSize = Math.max(maxRoomSize, roomSize);
                    roomSize = 0;
                }
            }
        }

        bfs();

        System.out.println(roomNumber);
        System.out.println(maxRoomSize);
        System.out.println(maxSumRoomSize);
    }

    static int m;
    static int n;
    static int maxRoomSize;
    static int maxSumRoomSize;
    static int roomSize;
    static int[] roomSizes;
    static int[][] map;
    static boolean[][] isVisited;

    // 서, 북, 동, 남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    // 방마다 번호를 매기고, 방 크기 측정
    static void dfs(int row, int col, int roomNumber) {
        roomSize++;

        char[] wall = checkWall(map[row][col]);
        isVisited[row][col] = true;
        map[row][col] = roomNumber;
        int direction = 0;

        for (int i = wall.length - 1; i >= 0; i--) {
            if (wall[i] == '0') {
                int tempX = row + dx[direction];
                int tempY = col + dy[direction];
                if (tempX >= 0 && tempY >= 0 && tempX < m && tempY < n && !isVisited[tempX][tempY]) {
                    dfs(tempX, tempY, roomNumber);
                }
            }
            direction++;
        }
    }

    // 합쳐진 방의 크기를 구함.
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int []{0, 0});
        isVisited = new boolean[m][n];
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];

                if (tempX >= 0 && tempY >=0 && tempX < m && tempY < n && !isVisited[tempX][tempY]) {
                    // 다른 방으로 갈 때 방 2개의 최대 크기
                    if (map[temp[0]][temp[1]] != map[tempX][tempY]) {
                        maxSumRoomSize = Math.max(maxSumRoomSize, roomSizes[map[temp[0]][temp[1]]] + roomSizes[map[tempX][tempY]]);
                    }
                    queue.add(new int[]{tempX, tempY});
                    isVisited[tempX][tempY] = true;
                }
            }
        }
    }

    // 이진수로 변환 (각 자리마다 방향을 나타냄)
    static char[] checkWall(int k) {
        char[] temp = new char[4];
        Arrays.fill(temp, '0');
        char[] wall = Integer.toBinaryString(k).toCharArray();
        System.arraycopy(wall, 0, temp, 4 - wall.length, wall.length);
        return temp;
    }
}
