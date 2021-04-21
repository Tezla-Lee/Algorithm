package 연습문제.깊이너비우선탐색.단어변환;

class Solution {
    public int solution(String begin, String target, String[] words) {
        isUsed = new boolean[words.length];
        bfs(begin, target, words, 0);
        if (flag) {
            return min;
        } else {
            return 0;
        }
    }

    static boolean[] isUsed;
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;

    static void bfs(String begin, String end, String[] words, int depth) {
        if (begin.equals(end)) {
            min = Math.min(min, depth);
            flag = true;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isUsed[i] && changeable(begin, words[i])) {
                isUsed[i] = true;
                bfs(words[i], end, words, depth + 1);
                isUsed[i] = false;
            }
        }
    }

    static boolean changeable(String s, String target) {
        if (s.length() != target.length()) {
            return false;
        }
        char[] temp = s.toCharArray();
        char[] temp2 = target.toCharArray();
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != temp2[i]) {
                count++;
            }
        }
        return count == 1;
    }
}