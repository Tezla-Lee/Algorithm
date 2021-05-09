package _2021_카인.프로그래밍3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution2 {
    private int pointer;
    private Stack<Row> deleteIndexStack;
    private List<Integer> list;

    public String solution(int n, int k, String[] cmd) {
        deleteIndexStack = new Stack<>();
        pointer = k;
        list = new ArrayList<>(cmd.length);

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (String c : cmd) {
            String[] command = c.split(" ");
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

        return getResult(n);
    }

    private void selectUp(int count) {
        pointer -= count;
    }

    private void selectDown(int count) {
        pointer += count;
    }

    private void deleteRow() {
        deleteIndexStack.push(new Row(pointer, list.remove(pointer)));

        if (pointer >= list.size()) {
            pointer = list.size() - 1;
        }
    }

    private void recoverLastDeletedRow() {
        Row row = deleteIndexStack.pop();

        if (row.index >= list.size()) {
            list.add(row.number);
            return;
        }

        int temp = list.get(pointer);

        list.add(row.index, row.number);

        if (row.number < temp) {
            pointer++;
        }
    }

    private String getResult(int n) {
        char[] chars = new char[n];

        Arrays.fill(chars, 'X');

        for (int index : list) {
            chars[index] = 'O';
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println("---------------------");
        System.out.println(new Solution2().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    private static class Row {
        int index;
        int number;

        public Row(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
