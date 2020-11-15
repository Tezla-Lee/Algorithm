package b10828;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                stack.push(command.substring(5));
            } else if (command.contains("pop")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (command.contains("size")) {
                bw.write(stack.size() + "\n");
            } else if (command.contains("empty")) {
                if (stack.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (command.contains("top")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }
//        System.out.println(sb);
        bw.close();
    }
}