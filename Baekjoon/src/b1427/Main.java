package b1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] numbers = br.readLine().split("");
        Arrays.sort(numbers, ((o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1)));
        for (String n : numbers) {
            sb.append(n);
        }
        System.out.println(sb);
    }
}