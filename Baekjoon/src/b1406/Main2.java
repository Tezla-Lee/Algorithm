package b1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        char[] c = br.readLine().toCharArray();

        for (char value : c) {
            lStack.push(value);
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.charAt(0) == 'P') {
                lStack.push(command.charAt(2));
            } else if (command.charAt(0) == 'L') {
                if (!lStack.isEmpty()) {
                    rStack.push(lStack.pop());
                }
            } else if (command.charAt(0) == 'D') {
                if (!rStack.isEmpty()) {
                    lStack.push(rStack.pop());
                }
            } else if (command.charAt(0) == 'B') {
                if (!lStack.isEmpty()) {
                    lStack.pop();
                }
            }
        }
        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }
        System.out.println(sb);
    }
}
