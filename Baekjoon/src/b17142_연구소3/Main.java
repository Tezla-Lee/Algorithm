package b17142_연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        map2 = new int[n][n];

        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                if (temp[j].equals("2")) {
                    arrayList.add(new int[]{i, j});
                    map[i][j] = -1;
                } else if (temp[j].equals("0")) {
                    map[i][j] = -2;
                }
            }
        }

        virusInfo = new int[arrayList.size()][2];
        for (int i = 0; i < virusInfo.length; i++) {
            virusInfo[i] = arrayList.get(i);
        }

        isUsed = new boolean[virusInfo.length];
        selectVirus = new int[m][2];

        setVirus(0, 0);

        if (flag) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    static int n;
    static int m;
    static int[][] map;
    static int[][] map2;
    static int[][] virusInfo;
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] isVisited;

    static void bfs() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            map2[i] = map[i].clone();
        }

        isVisited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();


        for (int[] virus : selectVirus) {
            queue.offer(virus);
            isVisited[virus[0]][virus[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];

                if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < n && !isVisited[tempX][tempY]) {
                    if (map2[tempX][tempY] == -2) {
                        map2[tempX][tempY] = map2[temp[0]][temp[1]] + 1;
                        max = Math.max(max, map2[tempX][tempY]);
                        queue.offer(new int[]{tempX, tempY});
                        isVisited[tempX][tempY] = true;
                    } else if (map2[tempX][tempY] == -1) {
                        queue.offer(new int[]{tempX, tempY});
                        isVisited[tempX][tempY] = true;
                        map2[tempX][tempY] = map2[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }

        if (check(map2)) {
            min = Math.min(min, max);
            flag = true;
        }
    }

    static boolean[] isUsed;
    static int[][] selectVirus;

    static void setVirus(int count, int index) {
        if (count == m) {

            bfs();

            return;
        }

        for (int i = index; i < virusInfo.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                selectVirus[count][0] = virusInfo[i][0];
                selectVirus[count][1] = virusInfo[i][1];
                map[virusInfo[i][0]][virusInfo[i][1]] = 0;

                setVirus(count + 1, i + 1);

                isUsed[i] = false;
                map[virusInfo[i][0]][virusInfo[i][1]] = -1;
            }
        }
    }

    static boolean check(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -2) {
                    return false;
                }
            }
        }
        return true;
    }
}