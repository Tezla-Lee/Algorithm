package b1110;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int newNum = num;
        int rotate = 0;
        if (num < 10) {
            newNum = num * 10;
            num *= 10;
        }
        do {
            newNum = (((newNum / 10) + (newNum % 10)) % 10) + ((newNum % 10) * 10);
            rotate++;
        }
        while (newNum != num);
        System.out.println(rotate);
    }
}