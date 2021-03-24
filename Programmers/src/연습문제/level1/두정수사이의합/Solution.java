package 연습문제.level1.두정수사이의합;

public class Solution {
    public long solution(int a, int b) {
        return (long) (Math.abs(a - b) + 1) * (a + b) / 2;
    }
}
