package b3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] locationX = new int[1001];
        int[] locationY = new int[1001];
        for (int i = 0; i < 3; i++) {
            String[] xy = br.readLine().split(" ");
            locationX[Integer.parseInt(xy[0])]++;
            locationY[Integer.parseInt(xy[1])]++;
        }
        for (int i = 1; i <= locationX.length; i++) {
            if (locationX[i] == 1) {
                sb.append(i);
                break;
            }
        }
        sb.append(" ");
        for (int i = 1; i <= locationY.length; i++) {
            if (locationY[i] == 1) {
                sb.append(i);
                break;
            }
        }
        System.out.println(sb);
    }
}
