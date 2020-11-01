package b1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int[] alphabets = new int[123];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 97) {
                alphabets[s.charAt(i) - 32]++;
            } else {
                alphabets[s.charAt(i)]++;
            }
        }
        int max = 0;
        for (int i = 0; i < alphabets.length; i++) {
            max = Math.max(max, alphabets[i]);
        }
        int count = 0;
        int maxCheck = 0;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == max) {
                count++;
                maxCheck = i;
            }
            if (count == 2) {
                System.out.println('?');
                break;
            }
        }
        if (count == 1)
        System.out.println((char)maxCheck);
    }
}