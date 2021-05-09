package 연습문제.level2.올바른괄호;

class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
