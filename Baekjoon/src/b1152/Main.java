package b1152;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] arr = str.trim().split(" ");
        int answer = 0;
        if (arr[0].equals("")) {
            System.out.println(0);
        } else {
            System.out.println(arr.length);
        }
    }
}