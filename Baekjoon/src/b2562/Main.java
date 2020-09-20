package b2562;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int count = 0;
        int num;
        int maxCount = 0;
        for (int i = 0; i < 9; i++) {
            count++;
            num = sc.nextInt();
            max = Math.max(num, max);
            if (max == num) {
                maxCount = count;
            }
        }
        System.out.println(max);
        System.out.println(maxCount);
    }
}
