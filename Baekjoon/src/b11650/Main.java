package b11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] xy;
//        Coordinate[] coordinates = new Coordinate[n];
////        List<Coordinate> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            xy = br.readLine().split(" ");
////            coordinates[i] = new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
////            list.add(new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
//        }
////        Collections.sort(list);
//        Arrays.sort(coordinates);
//        for (int i = 0; i < n; i++) {
////            sb.append(list.get(i) + "\n");
//            sb.append(coordinates[i] + "\n");
//        }
//        System.out.println(sb);





        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < n; i++) {
            xy = br.readLine().split(" ");
            priorityQueue.add(new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll() + "\n");
        }
        System.out.println(sb);
    }
}