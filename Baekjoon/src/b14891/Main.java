package b14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                wheelsInfo[i][j] = s[j];
            }
        }
        int wheel1 = 0;
        int wheel2 = 0;
        int wheel3 = 0;
        int wheel4 = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

        }
    }

//    static void

    static char[][] wheelsInfo = new char[4][8];
}
