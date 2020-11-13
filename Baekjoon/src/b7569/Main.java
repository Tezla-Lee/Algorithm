package b7569;

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
        int h = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        box = new int[h][n][m];
        check = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        bfs();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    max = Math.max(check[i][j][k], max);
                }
            }
        }
        if (count == count2) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }

    static int[][][] box;
    static int[][][] check;
    static int[] dx = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, -1, 0, 0, 1, 0};
    static int[] dz = {0, 0, 1, 0, 0, -1};
    static int count;
    static int count2;

    static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                for (int k = 0; k < box[0][0].length; k++) {
                    if (box[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    } else if (box[i][j][k] == 0) {
                        count++;
                    }
                }
            }
        }

        Tomato temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            int tempX, tempY, tempZ;
            for (int i = 0; i < 6; i++) {
                tempX = temp.x + dx[i];
                tempY = temp.y + dy[i];
                tempZ = temp.z + dz[i];
                if (tempX >= 0 && tempY >= 0 && tempZ >= 0 && tempX < box.length && tempY < box[0].length && tempZ < box[0][0].length) {
                    if (box[tempX][tempY][tempZ] == 0 && check[tempX][tempY][tempZ] == 0) {
                        queue.offer(new Tomato(tempX, tempY, tempZ));
                        check[tempX][tempY][tempZ] = check[temp.x][temp.y][temp.z] + 1;
                        count2++;
                    }
                }
            }
        }
    }
}

class Tomato {
    int x;
    int y;
    int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
