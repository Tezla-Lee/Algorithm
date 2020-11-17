package b1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder("<");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int delete = 0;
        while (!list.isEmpty()) {
            delete = (k + delete - 1) % list.size();
            if (list.size() == 1) {
                sb.append(list.remove(delete));
            } else {
                sb.append(list.remove(delete)).append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
