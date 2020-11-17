package b1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!priorityQueue.isEmpty()) {
                    sb.append(priorityQueue.poll());
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else {
                priorityQueue.offer(num);
            }
        }
        System.out.println(sb);
    }
}
