package b2577;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt());
        int[] count = new int[10];

        for (int i = 0; i < number.length(); i++) {
            count[Integer.parseInt(String.valueOf(number.charAt(i)))]++;
        }

        for (int num : count) {
            System.out.println(num);
        }
    }
}