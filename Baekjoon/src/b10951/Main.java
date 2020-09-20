package b10951;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] numbers = sc.nextLine().split(" ");
            System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }
    }
}