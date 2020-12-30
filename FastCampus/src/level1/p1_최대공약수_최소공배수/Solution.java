package level1.p1_최대공약수_최소공배수;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int gcd = 1;
        for (int i = 1; i <= min ; i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }
        answer[0] = gcd;
        answer[1] = m * n / gcd;
        return answer;
    }
}