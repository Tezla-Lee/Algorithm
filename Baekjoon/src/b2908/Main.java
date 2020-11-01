package b2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine()).reverse();
        String[] numbers = sb.toString().split(" ");
        System.out.println(Math.max(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));

    }
}
