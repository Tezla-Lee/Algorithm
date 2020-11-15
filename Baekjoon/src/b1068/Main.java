package b1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] info = new int[num];
        isVisited = new boolean[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        int delete = Integer.parseInt(br.readLine());
        nodes = new int[num][num];
        for (int i = 0; i < num; i++) {
            if (info[i] == -1) {
                continue;
            }
            nodes[info[i]][i] = 1;
        }
        for (int i = 0; i < num; i++) {
            if (info[i] == -1 && !isVisited[i]) {
                dfs(i, delete);
            }
        }
        System.out.println(count);
    }

    static boolean[] isVisited;
    static int[][] nodes;
    static int count;

    static void dfs(int start, int delete) {
        isVisited[start] = true;
        boolean flag = true;
        if (delete == start) {
            return;
        }
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[start][i] == 1 && !isVisited[i] && delete != i) {
                dfs(i, delete);
                flag = false;
            }
        }
        if (flag) {
            count++;
        }
    }
}
