package b5052_전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];

            for (int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }

            if (isConsistent(phoneNumbers)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isConsistent(String[] phoneNumbers) {
        for (int i = 0; i < phoneNumbers.length; i++) {
            for (int j = i + 1; j < phoneNumbers.length; j++) {
                if (phoneNumbers[j].startsWith(phoneNumbers[i]) || phoneNumbers[i].startsWith(phoneNumbers[j])) {
                    return false;
                }
            }
        }

        return true;
    }
}
