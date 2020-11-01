package b2675;

import java.util.Scanner;

class Main {
    static String stringCopy(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < n; j++) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.nextLine().trim();
            System.out.println(stringCopy(s, n));
        }
    }
}
