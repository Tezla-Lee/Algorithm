package SummerWinterCoding2018.점프와순간이동;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            while (n % 2 == 0) {
                n /= 2;
            }
            if (n > 0) {
                n--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(5000));
    }
}
