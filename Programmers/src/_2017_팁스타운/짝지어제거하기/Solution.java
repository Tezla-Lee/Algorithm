package _2017_팁스타운.짝지어제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        String[] list = s.split("");
        Stack<String> stack = new Stack<>();
        String temp;
        for (int i = 0; i < list.length; i++) {
            temp = list[i];
            if (!stack.isEmpty() && stack.peek().equals(temp)) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }

        if (stack.size() > 0) {
            return 0;
        }
        return 1;
    }
}