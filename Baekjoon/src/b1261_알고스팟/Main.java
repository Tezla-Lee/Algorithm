package b1261_알고스팟;

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

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m]; // 지도
        int[][] d = new int[n][m]; // 벽을 몇 개 부수었는지 저장

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE); // 왔던 곳인지 확인을 위해 초기값 -1 세팅
        }

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(map, d));
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int bfs(char[][] map, int[][] d) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        d[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
                    if (map[nextX][nextY] == '1') {
                        if (d[curr[0]][curr[1]] + 1 < d[nextX][nextY]) {
                            d[nextX][nextY] = d[curr[0]][curr[1]] + 1;
                            queue.add(new int[]{nextX, nextY});
                        }
                    } else {
                        if (d[curr[0]][curr[1]] < d[nextX][nextY]) {
                            d[nextX][nextY] = d[curr[0]][curr[1]];
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
        return d[d.length - 1][d[0].length - 1];
    }
}