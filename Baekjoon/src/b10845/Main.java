package b10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        String end = "";
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.charAt(1) == 'u') {
                end = command.substring(5);
                queue.offer(end);
            } else if (command.charAt(1) == 'o') {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (command.charAt(1) == 'i') {
                sb.append(queue.size()).append("\n");
            } else if (command.charAt(1) == 'm') {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.charAt(1) == 'r') {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (command.charAt(1) == 'a') {
                if (!queue.isEmpty()) {
                    sb.append(end).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb);
    }
}