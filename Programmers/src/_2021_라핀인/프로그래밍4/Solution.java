package _2021_라핀인.프로그래밍4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<Integer>[] stacks;
    private final int EMPTY_NUMBER = Integer.MIN_VALUE;
    int centerNumber;

    public int[] solution(int n, int[][] queries) {
        stacks = new LinkedList[n + 1];
        centerNumber = EMPTY_NUMBER;
        List<Integer> popNums = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            stacks[i] = new LinkedList<>();
        }

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];

            if (b == -1) {
                int popNumber = pop(a);
                popNums.add(popNumber == EMPTY_NUMBER ? -1 : popNumber);
            } else {
                push(a, b);
            }
        }

        int[] result = new int[popNums.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = popNums.get(i);
        }

        return result;
    }

    private void push(int stackNum, int number) {
        if (centerNumber == EMPTY_NUMBER) {
            centerNumber = number;
        } else {
            stacks[stackNum].addLast(number);
        }
    }

    private int pop(int stackNum) {
        if (stacks[stackNum].isEmpty()) { // 해당 스택이 비어있으면
            if (centerNumber == EMPTY_NUMBER) { // 공유 숫자가 없으면
                return centerNumber;
            } else { // 공유 숫자가 있으면 제거
                int center = centerNumber;
                centerNumber = EMPTY_NUMBER;

                fillCenter(stackNum); // 공유 숫자를 스택에서 채움

                return center;
            }
        }
        return stacks[stackNum].removeLast();
    }

    // 공유(중앙) 숫자가 제거되었을 때 채움
    private void fillCenter(int stackNum) {
        for (int i = 0; i < stacks.length; i++) {
            int target = (stackNum + i) % stacks.length;

            if (!stacks[target].isEmpty()) {
                centerNumber = stacks[target].removeFirst();
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(3, new int[][]{{1, 4}, {2, 2}, {1, 3}, {1, 6}, {3, -1}, {2, -1}})));
        System.out.println(Arrays.toString(new Solution().solution(4, new int[][]{{1, 3}, {1, 2}, {3, 6}, {3, -1}, {4, 5},
                {2, -1}, {3, -1}, {1, -1}})));
        System.out.println(Arrays.toString(new Solution().solution(5, new int[][]{{1, -1}, {2, -1}, {3, -1}, {4, -1},
                {5, -1}})));
    }
}