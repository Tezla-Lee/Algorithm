package 연습문제.level2._124나라의숫자;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 3 == 0) {
                sb.insert(0, "4");
                n--;
            } else if (n % 3 == 2) {
                sb.insert(0, "2");
            } else {
                sb.insert(0, "1");
            }
            n /= 3;
        }

        return sb.toString();
    }
}
