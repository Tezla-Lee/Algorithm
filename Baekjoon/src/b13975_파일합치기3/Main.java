package b13975_파일합치기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Queue<Long> queue = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (queue.size() > 1) {
                long s1 = queue.poll();
                long s2 = queue.poll();
                sum += s1 + s2;
                queue.add(s1 + s2);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}