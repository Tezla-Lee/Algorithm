package b1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] pocketMonBook = new String[n + 1];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            String temp = br.readLine();
            pocketMonBook[i] = temp;
            map.put(temp, i);
        }
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (map.containsKey(temp)) {
                sb.append(map.get(temp));
            } else {
                sb.append(pocketMonBook[Integer.parseInt(temp)]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}