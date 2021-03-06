package level1._2016년;


public class Solution {
    public String solution(int a, int b) {
        return printDayOfWeek(a, b);
    }

    public int printDayOfMonth(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return 29;
            default:
                return 30;
        }
    }

    public String printDayOfWeek(int month, int day) {
        int sum = day + 5;
        for (int i = 1; i < month; i++) {
            sum += printDayOfMonth(i);
        }

        switch (sum % 7) {
            case 1:
                return "SUN";
            case 2:
                return "MON";
            case 3:
                return "TUE";
            case 4:
                return "WED";
            case 5:
                return "THU";
            case 6:
                return "FRI";
            default:
                return "SAT";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1, 1));
    }
}

