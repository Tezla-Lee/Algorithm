package _2017_카카오코드본선.단체사진찍기;

import java.util.*;

class Solution {
    Map<Integer, Character> map;
    char[] line;
    boolean[] isVisited;
    int count;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    public int solution(int n, String[] data) {
        line = new char[8];
        isVisited = new boolean[8];
        map = new HashMap<>();
        count = 0;

        setUpMap();
        lineUp(0, data);

        return count;
    }

    private void lineUp(int index, String[] data) {
        if (index == 8) {
            for (String condition : data) {
                if (!check(condition)) {
                    return;
                }
            }
            count++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                line[i] = map.get(index);
                lineUp(index + 1, data);
                isVisited[i] = false;
            }
        }
    }

    private boolean check(String condition) {
        char[] chars = condition.toCharArray();

        int friend1 = -1;
        int friend2 = -1;

        for (int i = 0; i < 8; i++) {
            if (line[i] == chars[0]) {
                friend1 = i;
            }
            if (line[i] == chars[2]) {
                friend2 = i;
            }
        }

        int distance = Math.abs(friend1 - friend2);

        if (chars[3] == '=') {
            return distance == chars[4] + 1 - '0';
        } else if (chars[3] == '>') {
            return distance > chars[4] + 1 - '0';
        } else {
            return distance < chars[4] + 1 - '0';
        }
    }

    private void setUpMap() {
        map.put(0, 'A');
        map.put(1, 'C');
        map.put(2, 'F');
        map.put(3, 'J');
        map.put(4, 'M');
        map.put(5, 'N');
        map.put(6, 'R');
        map.put(7, 'T');
    }
}