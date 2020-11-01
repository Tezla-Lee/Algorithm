package b1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int num = 0;
        int line = 1;
        while (num < x) {
            num += line++;
        }
        line--;
        if (line % 2 == 0) {
            System.out.println(line - (num - x) + "/" + (num - x + 1));
        } else {
            System.out.println((num - x + 1) + "/" + (line - (num - x)));
        }
    }
}
