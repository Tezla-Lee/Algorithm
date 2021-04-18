package valid_parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char peek = stack.peek();

                if (c == ')') {
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (peek == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.add(c);
                }
            } else {
                if (c == ')' || c == ']' || c == '}') {
                    return false;
                }
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
