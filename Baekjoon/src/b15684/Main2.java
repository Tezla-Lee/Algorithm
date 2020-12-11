package b15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[h + 1][n + 2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b + 1] = -1;
        }
        connectLadder(1, 1, 0);
//        System.out.println("-1");
        System.out.println(min);
    }

    static int n, m, h;
    static int[][] ladder;
    static int[][] addLadders;
    static int min = Integer.MAX_VALUE;

    static void connectLadder(int a, int b, int depth) {
        if (depth == 0) {
            if (correctConnection()) {
                System.out.println("0");
                return;
            }
        }

        if (depth == 3) {
            return;
        }

        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (i <= a && j < b) {
                    continue;
                }
                if (ladder[i][j] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = -1;
                    if (correctConnection()) {
                        min = Math.min(min, depth + 1);
                    }
                    connectLadder(i, j, depth + 1);
                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }

    }

    static boolean correctConnection() {
        for (int i = 1; i < n + 1; i++) {
            int ladderNumber = i;
            int height = 0;
            while (height <= h) {
                ladderNumber += ladder[height][ladderNumber];
                height++;
            }
            if (ladderNumber != i) {
                return false;
            }
        }
        return true;
    }
}