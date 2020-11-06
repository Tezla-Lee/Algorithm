package 월간코드챌린지시즌1.삼각달팽이;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int number = 1;
    static ArrayList[] arrayList;

    public Object[] solution(int n) {
        arrayList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }
        int end = n * (n + 1) / 2;
        ArrayList<Integer> answer = new ArrayList<>();
        inputNum(arrayList, 0, end, n, 0);
        for (ArrayList<Integer> array : arrayList) {
            for (int i : array) {
                answer.add(i);
            }
        }
        return answer.toArray();
    }

    public void inputNum(ArrayList[] arr, int start, int end, int n, int input) {
        int temp = input + 1;
        for (int i = start; i < n; i++) {
            arr[i].add(input, number++);
            if (number > end) {
                return;
            }
        }
        for (int i = 0; i < n - start - 1; i++) {
            if (number >= end - n + 1) {
                arr[n - 1].add(temp++, number++);
            } else {
                arr[n - 1].add(temp++, number++);
            }
            if (number > end) {
                return;
            }
        }
        for (int i = n - 2; i >= start + 1; i--) {
            arr[i].add(arr[i].size() - input, number++);
            if (number > end) {
                return;
            }
        }
        if (number <= end) {
            inputNum(arr, start + 2, end, n - 1, input + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(4)));
        for (ArrayList arr : arrayList) {
            System.out.println(arr);
        }
    }
}