package _2021_가.프로그래밍2;

class Solution {
    public boolean solution(int[] arr, int n) {
        boolean[] check = new boolean[100000001]; // arr 에 있는 수 체크

        for (int number : arr) {
            check[number] = true;
        }

        for (int number : arr) {
            if (n - number > 0 && n - number <= 100000000 && n != number * 2 && check[n - number]) { // n - number가 있는지 확인
                return true;
            }
        }

        return false;
    }
}