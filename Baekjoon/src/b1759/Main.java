package b1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chars = new char[c];
        isUsed = new boolean[c];
        password = new char[l];
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(chars);
        createPassword(0, 0, 0, 0);
        System.out.println(sb);
    }

    static char[] chars;
    static boolean[] isUsed;
    static char[] password;
    static StringBuilder sb = new StringBuilder();

    static void createPassword(int count1, int count2, int depth, int index) {
        if (depth == password.length) {
            if (count1 >= 2 && count2 >= 1) {
                for (char c : password) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = index; i < chars.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                password[depth] = chars[i];
                if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    createPassword(count1, count2 + 1, depth + 1, i);
                } else {
                    createPassword(count1 + 1, count2, depth + 1, i);
                }
                isUsed[i] = false;
            }
        }
    }
}