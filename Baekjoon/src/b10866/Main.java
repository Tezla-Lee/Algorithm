package b10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push_front")) {
                deque.addFirst(command[1]);
            } else if (command[0].equals("push_back")) {
                deque.addLast(command[1]);
            } else if (command[0].equals("pop_front")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command[0].equals("pop_back")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command[0].equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command[0].equals("empty")) {
                if (!deque.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (command[0].equals("front")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command[0].equals("back")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
