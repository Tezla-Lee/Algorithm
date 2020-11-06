package SummerWinterCoding2018.영어끝말잇기;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Stack<String> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!stack.isEmpty() && (stack.contains(words[i]) || stack.peek().charAt(stack.peek().length() - 1) != words[i].charAt(0))) {
                count = i + 1;
                break;
            } else {
                stack.add(words[i]);
            }
        }
        System.out.println(count);
        if (count != 0) {
            answer[0] = count % n == 0 ? n : count % n;
            answer[1] = count % n != 0 ? count / n + 1 : count / n;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(new Solution().solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
//        Stack<String> stack = new Stack<>();
//        stack.add("tank");
//        System.out.println(stack.peek().charAt(stack.peek().length() - 1));
    }
}
