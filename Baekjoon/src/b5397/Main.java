package b5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char[] keyLog = br.readLine().toCharArray();
            for (char c : keyLog) {
                if (c == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (c == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (c == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(c);
                }
            }
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            sb.append("\n");
        }
    }
}