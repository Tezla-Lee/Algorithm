package b9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNum; i++) {
            int studentNum = Integer.parseInt(br.readLine());
            student = new int[studentNum + 1];
            isVisited = new boolean[studentNum + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < studentNum + 1; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[] student;
    static boolean[] isVisited;

    static void dfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.offer(start);
        if (start == end) {
            return;
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            queue.offer(student[temp]);
        }

    }
}
