package b1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = br.readLine().split(" ");
        if (Integer.parseInt(abc[2]) <= Integer.parseInt(abc[1])) {
            System.out.println(-1);
        } else {
            System.out.println(Integer.parseInt(abc[0]) / (Integer.parseInt(abc[2]) - Integer.parseInt(abc[1])) + 1);
        }
    }
}
