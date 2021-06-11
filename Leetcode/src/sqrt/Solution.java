package sqrt;

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            long temp = (long) mid * mid;

            if (temp < x) {
                left = mid + 1;
            } else if (temp > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}