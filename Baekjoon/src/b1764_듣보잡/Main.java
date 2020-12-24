package b1764_듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        String[] tempArr = new String[Math.max(n, m)];
        int index = 0;

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (hashSet.contains(temp)) {
                tempArr[index++] = temp;
            }
        }

        if (index > 0) {
            String[] answer = new String[index];
            System.arraycopy(tempArr, 0, answer, 0, index);
            Arrays.sort(answer);

            for (String s : answer) {
                sb.append(s).append("\n");
            }
        }
        System.out.println(index);
        System.out.println(sb);
    }
}