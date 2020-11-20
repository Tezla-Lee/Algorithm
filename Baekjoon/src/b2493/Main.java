package b2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        int height;
        int index = 0;
        while (st.hasMoreTokens()) {
            index++;
            height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(new Top(index, height));
                sb.append(0).append(" ");
            } else if (stack.peek().height < height) {
                while (!stack.isEmpty() && stack.peek().height < height) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(stack.peek().index).append(" ");
                }
                stack.push(new Top(index, height));
            } else if (stack.peek().height > height) {
                sb.append(stack.peek().index).append(" ");
                stack.push(new Top(index, height));
            }
        }
        System.out.println(sb);
    }
}

class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}