package b9372_상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] info = new int[n + 1][n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int departure = Integer.parseInt(st.nextToken());
                int arrival = Integer.parseInt(st.nextToken());
                info[departure][arrival] = 1;
                info[arrival][departure] = 1;
            }
            isVisited = new boolean[n + 1];
            sb.append(bfs(1, info)).append("\n");
        }
        System.out.println(sb);
    }

    static int n;
    static int m;
    static boolean[] isVisited;

    static int bfs(int start, int[][] info) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (info[temp][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }
        return count;
    }
}
