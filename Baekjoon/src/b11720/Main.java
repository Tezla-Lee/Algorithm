package b11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split("");
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        System.out.println(sum);
    }
}
