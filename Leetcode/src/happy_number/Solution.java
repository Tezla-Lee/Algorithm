package happy_number;

class Solution {
    public boolean isHappy(int n) {
        int num = n;

        while (n != 1 && num != 1) {
            n = calculateEachSquare(n);
            num = calculateEachSquare(calculateEachSquare(num));

            if (n == num && n != 1) {
                return false;
            }
        }

        return true;
    }

    private int calculateEachSquare(int number) {
        int sum = 0;

        while (number > 0) {
            int num = number % 10;

            sum += num * num;
            number /= 10;
        }

        return sum;
    }
}