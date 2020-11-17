package b1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input < num) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == input) {
                        stack.pop();
                        sb.append("-\n");
                    } else {
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
            } else {
                while (input >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        if (!flag) {
            System.out.println(sb);
        }
    }
}
