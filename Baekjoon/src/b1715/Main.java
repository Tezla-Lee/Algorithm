package b1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;

        // 큐에 하나가 남을 때까지 큐에서 가장 작은 수 2개를 더해서 다시 큐에 넣어줌.
        while (priorityQueue.size() != 1) {
            int temp = priorityQueue.poll() + priorityQueue.poll();
            sum += temp;
            priorityQueue.add(temp);
        }
        System.out.println(sum);
    }
}