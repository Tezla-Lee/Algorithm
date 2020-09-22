package b10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        boolean check;
        for (int i = 'a'; i <= 'z'; i++) {
            check = false;
            for (int j = 0; j < word.length; j++) {
                if (word[j].equals(String.valueOf((char) i))) {
                    sb.append(j).append(" ");
//                    System.out.printf("%d ", j);
                    check = true;
                    break;
                }
            }
            if (!check) {
                sb.append(-1).append(" ");
//                System.out.print(-1 + " ");
            }
        }
        System.out.println(sb);
    }
}