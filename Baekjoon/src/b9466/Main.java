package b9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n + 1];
            isVisited = new boolean[n + 1];
            isFinished = new boolean[n + 1];
            count = 0;
            teamNumber = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if (!isVisited[j]) {
                    dfs(j, student[j]);
                }
            }
            System.out.println(Arrays.toString(isFinished));
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    static int count;
    static int teamNumber;
    static int[] student;
    static boolean[] isFinished;
    static boolean[] isVisited;

    static void dfs(int start, int next) {
        isVisited[start] = true;
        if (!isVisited[next]) {
            dfs(next, student[next]);
        } else {
            if (!isFinished[next]) {
                count++;
                for (int i = next; i != start; i = student[i]) {
                    count++;
                }
            }
        }
        isFinished[start] = true;
    }
}