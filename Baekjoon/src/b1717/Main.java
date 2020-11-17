package b1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
            arrayLists[i].add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int temp1 = -1, temp2 = -2;
            boolean flag1 = false;
            boolean flag2 = false;
            for (int j = 0; j < arrayLists.length; j++) {
                if (arrayLists[j].contains(num2)) {
                    temp1 = j;
                    flag1 = true;
                }
                if (arrayLists[j].contains(num3)) {
                    temp2 = j;
                    flag2 = true;
                }
                if (flag1 && flag2) {
                    break;
                }
            }

            if (num1 == 0) {
                if (temp1 != temp2) {
                    arrayLists[temp1].addAll(arrayLists[temp2]);
                    arrayLists[temp2] = new ArrayList<>();
                }
            } else {
                if (temp1 == temp2) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
