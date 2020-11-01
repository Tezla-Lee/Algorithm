package b2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nailVelo = br.readLine().split(" ");
        int a = Integer.parseInt(nailVelo[0]);
        int b = Integer.parseInt(nailVelo[1]);
        int v = Integer.parseInt(nailVelo[2]);
        if ((v - b) % (a - b) == 0) {
            System.out.println((v - b) / (a - b));
        } else {
            System.out.println((v - b) / (a - b) + 1);
        }
    }
}