package 연습문제.level1.약수의합;

class Solution {
    public int solution(int n) {
        int sum = 0;

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }

        // n이 제곱수 인경우
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            sum -= Math.sqrt(n);
        }

        return sum;
    }
}