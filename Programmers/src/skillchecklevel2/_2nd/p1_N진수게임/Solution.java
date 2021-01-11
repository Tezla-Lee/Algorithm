package skillchecklevel2._2nd.p1_N진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (sb.length() < m * t + p) {
            sb.append(trans(number++, n));
        }
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < t; i++) {
            answer.append(chars[p - 1 + i * m]);
        }
        return answer.toString();
    }

    static String trans(int num, int n) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num % n < 10) {
                sb.append(num % n);
            } else {
                sb.append((char) (num % n + 55));
            }
            num /= n;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 4, 2, 1));
        System.out.println(new Solution().solution(16, 16, 2, 1));
    }
}
