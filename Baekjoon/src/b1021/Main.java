package b1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }
        Queue<Integer> want = new LinkedList<>();
        int count = 0;
        int current = 0;
        while (st.hasMoreTokens()) {
            want.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            int next = want.poll();
            count += Math.min(Math.abs(list.indexOf(next) - current), list.size() - Math.abs(list.indexOf(next) - current));
            current = list.indexOf(next);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == next) {
                    list.remove(j);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}