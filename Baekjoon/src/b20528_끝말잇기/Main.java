package b20528_끝말잇기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstLetter = st.nextToken().charAt(0);

        for (int i = 1; i < n; i++) {
            String s = st.nextToken();
            if (firstLetter != s.charAt(0)) {
                System.out.println("0");
                return;
            }
            firstLetter = s.charAt(0);
        }

        System.out.println("1");
    }
}
