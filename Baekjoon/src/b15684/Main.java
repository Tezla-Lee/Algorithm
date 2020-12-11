package b15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[n + 2][h + 1];
        addLadders = new int[3][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[b][a] = 1;
            ladder[b + 1][a] = -1;
        }
        connectLadder(1, 0);
//        System.out.println("-1");
        System.out.println(min);
    }

    static int n, m, h;
    static int[][] ladder;
    static int[][] addLadders;
    static int min = Integer.MAX_VALUE;

    static void connectLadder(int a, int count) {
        if (count == 0) {
            if (correctConnection()) {
                System.out.println("0");
                System.exit(0);
                return;
            }
        }
        if (count == 3) {
            return;
        }

        for (int i = a; i < n; i++) {
            for (int j = 1; j < h + 1; j++) {
                if (ladder[i][j] == 0 && ladder[i + 1][j] == 0) {
                    ladder[i][j] = 1;
                    ladder[i + 1][j] = -1;
                    addLadders[count][0] = i;
                    addLadders[count][1] = j;
                    if (correctConnection()) {
                        min = Math.min(min, count + 1);
                        return;
                    }
                    connectLadder(i, count + 1);
                    ladder[i][j] = 0;
                    ladder[i + 1][j] = 0;
                    addLadders[count][0] = 0;
                    addLadders[count][1] = 0;
                }
            }
        }
    }

    static boolean correctConnection() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            int ladderNum = i;
            int height = 0;
            while (height <= h) {
                sb.append(ladderNum).append(" ").append(height).append("\n");
                if (ladder[ladderNum][height] != 0) {
                    ladderNum += ladder[ladderNum][height];
                    sb.append("이동\n");
                }
                height++;
            }
            if (ladderNum != i) {
                return false;
            }
            sb.append("\n");
        }
        System.out.println(Arrays.deepToString(addLadders));
        System.out.println(sb);
        System.out.println(Arrays.deepToString(ladder));
        System.out.println();
        return true;
    }
}