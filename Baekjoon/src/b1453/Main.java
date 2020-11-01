package b1453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        boolean[] isEmpty = new boolean[101];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            if(!isEmpty[Integer.parseInt(numbers[i])]) {
                isEmpty[Integer.parseInt(numbers[i])] = true;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
