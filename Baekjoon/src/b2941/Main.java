package b2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        int answer = 0;
        while (sb.indexOf("c=") != -1) {
            sb.replace(sb.indexOf("c="), sb.indexOf("c=") + 2, ".");
        }
        while (sb.indexOf("c-") != -1) {
            sb.replace(sb.indexOf("c-"), sb.indexOf("c-") + 2, ".");
        }
        while (sb.indexOf("dz=") != -1) {
            sb.replace(sb.indexOf("dz="), sb.indexOf("dz=") + 3, ".");
        }
        while (sb.indexOf("d-") != -1) {
            sb.replace(sb.indexOf("d-"), sb.indexOf("d-") + 2, ".");
        }
        while (sb.indexOf("lj") != -1) {
            sb.replace(sb.indexOf("lj"), sb.indexOf("lj") + 2, ".");
        }
        while (sb.indexOf("nj") != -1) {
            sb.replace(sb.indexOf("nj"), sb.indexOf("nj") + 2, ".");
        }
        while (sb.indexOf("s=") != -1) {
            sb.replace(sb.indexOf("s="), sb.indexOf("s=") + 2, ".");
        }
        while (sb.indexOf("z=") != -1) {
            sb.replace(sb.indexOf("z="), sb.indexOf("z=") + 2, ".");
        }
        answer += sb.length();
        System.out.println(answer);
    }
}