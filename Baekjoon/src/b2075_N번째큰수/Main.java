package b2075_N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}