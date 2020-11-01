package b2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int honeyNumber = 1;
        int count = 1;
        while(number > honeyNumber) {
            honeyNumber += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
