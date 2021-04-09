package b16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (movePeople()) {
            count++;
        }

        System.out.println(count);
    }

    static boolean movePeople() {
        isVisited = new boolean[n][n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    if (bfs(i, j)) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

    static boolean bfs(int row, int col) {
        Queue<Country> queue = new LinkedList<>(); // bfs 위한 큐
        List<Country> countries = new ArrayList<>(); // 연결된 나라 리스트
        queue.add(new Country(row, col));
        countries.add(new Country(row, col));

        int sum = map[row][col];

        while (!queue.isEmpty()) {
            Country curr = queue.poll();
            int cr = curr.row;
            int cc = curr.col;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dx[i];
                int nc = cc + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !isVisited[nr][nc]) {
                    int sub = Math.abs(map[cr][cc] - map[nr][nc]);
                    if (sub >= l && sub <= r) {
                        isVisited[nr][nc] = true;
                        queue.add(new Country(nr, nc));
                        countries.add(new Country(nr, nc));
                        sum += map[nr][nc];
                    }
                }
            }
        }

        // 인구 분배
        for (Country country : countries) {
            map[country.row][country.col] = sum / countries.size();
        }

        return countries.size() > 1;
    }
}

class Country {
    int row;
    int col;

    public Country(int row, int col) {
        this.row = row;
        this.col = col;
    }
}