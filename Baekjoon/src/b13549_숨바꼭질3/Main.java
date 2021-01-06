package b13549_숨바꼭질3;

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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    static int bfs(int n, int k) {
        int[] isVisited = new int[100001];
        Arrays.fill(isVisited, Integer.MAX_VALUE);
        isVisited[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
//            System.out.println(isVisited[curr] + " : " + curr);
            if (curr == k) {
                return isVisited[k];
            }
            if (curr + 1 <= 100000 && isVisited[curr + 1] > isVisited[curr] + 1) {
                isVisited[curr + 1] = isVisited[curr] + 1;
                queue.add(curr + 1);
            }
            if (curr -1 >= 0 && isVisited[curr - 1] > isVisited[curr] + 1) {
                isVisited[curr - 1] = isVisited[curr] + 1;
                queue.add(curr - 1);
            }
            if (curr * 2 <= 100000 && isVisited[curr * 2] > isVisited[curr]) {
                isVisited[curr * 2] = isVisited[curr];
                queue.add(curr * 2);
            }
        }
        return -1;
    }
}
