package b1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        boolean check;
        for (int i = 0; i < num; i++) {
            check = false;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                int temp = j;
                int ch = str.charAt(j);
                for (int k = j + 1; k < str.length(); k++) {
                    if (str.charAt(k) == ch) {
                        if (temp + 1 < k) {
                            check = true;
                            break;
                        } else {
                            temp = k;
                        }
                    }
                }
            }
            if (!check) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
