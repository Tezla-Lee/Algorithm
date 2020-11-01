package b1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        int w = Integer.parseInt(numbers[2]);
        int h = Integer.parseInt(numbers[3]);
        System.out.println(Math.min(Math.min(x, w-x),Math.min(y, h-y)));
    }
}
