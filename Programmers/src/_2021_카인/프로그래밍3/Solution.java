package _2021_카인.프로그래밍3;

import java.util.Stack;

class Solution {
    private boolean[] isDeleted;
    private int pointer;
    private Stack<Integer> deleteIndexStack;
    private int lastIndex;

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        deleteIndexStack = new Stack<>();
        lastIndex = n - 1;
        isDeleted = new boolean[n];
        pointer = k;

        for (String c : cmd) {
            String[] command = c.split(" ");
            System.out.println(c + ", " + pointer);
            System.out.println();
            switch (command[0]) {
                case "U":
                    selectUp(Integer.parseInt(command[1]));
                    break;
                case "D":
                    selectDown(Integer.parseInt(command[1]));
                    break;
                case "C":
                    deleteRow();
                    break;
                default:
                    recoverLastDeletedRow();
                    break;
            }
        }

        for (boolean deleted : isDeleted) {
            if (deleted) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }

    private void selectUp(int count) {
        if (count >= pointer || pointer == 0) {
            pointer = 0;
            return;
        }

        while (count > 0) {
            while (true) {
                pointer--;
                if (pointer == 0) {
                    return;
                }

                if (!isDeleted[pointer]) {
                    count--;
                    break;
                }
            }
        }
    }

    private void selectDown(int count) {
        if (count + pointer >= isDeleted.length - 1 || pointer == isDeleted.length - 1) {
            pointer = isDeleted.length - 1;
            return;
        }

        while (count > 0) {
            while (true) {
                pointer++;
                if (pointer == isDeleted.length - 1) {
                    return;
                }

                if (!isDeleted[pointer]) {
                    count--;
                    break;
                }
            }
        }
    }

    private void deleteRow() {
        isDeleted[pointer] = true;
        deleteIndexStack.push(pointer);

        if (pointer == lastIndex) {
            while (isDeleted[pointer]) {
                pointer--;
            }
            lastIndex = pointer;
            return;
        }

        if (!isDeleted[pointer + 1]) {
            pointer++;
        }
    }

    private void recoverLastDeletedRow() {
        if (deleteIndexStack.isEmpty()) {
            return;
        }

        int target = deleteIndexStack.pop();

        isDeleted[target] = false;
        if (target > lastIndex) {
            lastIndex = target;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }
}
