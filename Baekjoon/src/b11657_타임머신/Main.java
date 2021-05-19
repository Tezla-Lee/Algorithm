package b11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static List<List<Edge>> edges;
    private static long[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        times = new long[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;

        edges = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges.get(start).add(new Edge(num, time));
        }

        if (bellmanFord()) {
            System.out.println("-1");
        } else {
            printShortestTime();
        }
    }

    private static boolean bellmanFord() {

        boolean update = false;

        for (int i = 1; i < n; i++) {
            update = false;
            for (int j = 1; j < n + 1; j++) {
                if (times[j] == Integer.MAX_VALUE) {
                    continue;
                }
                for (Edge edge : edges.get(j)) {
                    if (times[edge.num] > times[j] + edge.time) {
                        times[edge.num] = times[j] + edge.time;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i < n + 1; i++) {
                if (times[i] == Integer.MAX_VALUE) {
                    continue;
                }
                for (Edge edge : edges.get(i)) {
                    if (times[edge.num] > times[i] + edge.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void printShortestTime() {
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i < times.length; i++) {
            if (times[i] == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                sb.append(times[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Edge {
        int num;
        int time;

        public Edge(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
