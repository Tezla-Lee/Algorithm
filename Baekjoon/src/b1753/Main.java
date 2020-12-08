package b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int caseNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        isUsed = new boolean[n + 1][n + 1];
        route = new int[n + 1];
        int a, b, c;
        for (int i = 0; i < caseNum; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (board[a][b] != 0) {
                board[a][b] = Math.min(c, board[a][b]);
            } else {
                board[a][b] = c;
            }
        }
        dfs(start, 0);
        for (int i = 1; i < n + 1; i++) {
            if (i == start) {
                sb.append(0);
            } else {
                if (route[i] == 0) {
                    sb.append("INF");
                } else {
                    sb.append(route[i]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] board;
    static int[] route;
    static int n;
    static boolean[][] isUsed;

    static void dfs(int start, int distance) {
        for (int i = 1; i < n + 1; i++) {
            if (!isUsed[start][i] && board[start][i] != 0) {
                isUsed[start][i] = true;
//                if (route[i] == 0) {
//                    route[i] = distance + board[start][i];
//                } else {
//                    route[i] = Math.min(route[i], distance + board[start][i]);
//                }
//                dfs(i, distance + board[start][i]);

                if (route[i] == 0) {
                    route[i] = distance + board[start][i];
                } else {
                    if (distance + board[start][i] < route[i]) {
                        route[i] = distance + board[start][i];
                        dfs(i, distance + board[start][i]);
                    }
                }
            }
        }
    }
}

