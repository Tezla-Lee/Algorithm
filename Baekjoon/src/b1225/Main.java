package b1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        String[] num1 = numbers[0].split("");
        String[] num2 = numbers[1].split("");
        long sumNum1 = 0;
        long sumNum2 = 0;
        for (int i = 0; i < num1.length; i++) {
            sumNum1 += Integer.parseInt(num1[i]);
        }
        for (int i = 0; i < num2.length; i++) {
            sumNum2 += Integer.parseInt(num2[i]);
        }
        System.out.println(sumNum1 * sumNum2);
    }
}
