package _2021_라AD.프로그래밍1;

import java.util.Stack;

class Solution {
    private final char[] open = {'(', '{', '[', '<'};
    private final char[] close = {')', '}', ']', '>'};

    public int solution(String inputString) {
        char[] inputChars = inputString.toCharArray();
        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputChars.length; i++) {
            char letter = inputChars[i];
            if (isOpen(letter)) {
                stack.add(letter);
                continue;
            }

            if (isClose(letter)) {
                if (stack.isEmpty()) {
                    return -i;
                }

                char last = stack.peek();

                if (isCorrect(last, letter)) {
                    stack.pop();
                    count++;
                } else {
                    return -i;
                }
            }
        }

        if (stack.isEmpty()) { // 올바른 문자열임.
            return count;
        } else {
            return -inputChars.length + 1;
        }
    }

    private boolean isOpen(char letter) {
        return letter == '(' || letter == '{' || letter == '[' || letter == '<';
    }

    private boolean isClose(char letter) {
        return letter == ')' || letter == '}' || letter == ']' || letter == '>';
    }

    private boolean isCorrect(char last, char letter) {
        return (last == '(' && letter == ')') || (last == '{' && letter == '}')
                || (last == '[' && letter == ']') || (last == '<' && letter == '>');
    }
}