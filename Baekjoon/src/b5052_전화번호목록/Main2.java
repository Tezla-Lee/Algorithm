package b5052_전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            boolean flag = true;

            for (int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }

            Arrays.sort(phoneNumbers, String::compareTo);

            for (int j = 0; j < n - 1; j++) {
                if (phoneNumbers[j + 1].startsWith(phoneNumbers[j])) {
                    sb.append("NO");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("YES");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}